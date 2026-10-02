package com.mailnova.service.batch;


import com.mailnova.core.entity.EmailCampaignRecipientEntity;
import com.mailnova.core.repository.EmailCampaignRecipientRepository;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.data.RepositoryItemWriter;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.LineMapper;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.infrastructure.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.infrastructure.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.infrastructure.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class CampaignRecipientStoreBatch {

    private EmailCampaignRecipientRepository  emailCampaignRecipientRepository;

    public CampaignRecipientStoreBatch(EmailCampaignRecipientRepository emailCampaignRecipientRepository) {
        this.emailCampaignRecipientRepository = emailCampaignRecipientRepository;
    }

    @Bean
    @StepScope
    public FlatFileItemReader<EmailCampaignRecipientEntity>
    campaignDataReader(@Value("#{jobParameters['filePath']}") String filePath,
                       @Value("#{jobParameters['campaignId']}") String campaignId) {

        return new FlatFileItemReaderBuilder<EmailCampaignRecipientEntity>()
                .name("EmailCampRecipient_"+campaignId)
                .resource(new FileSystemResource(filePath))
                .linesToSkip(1)
                .lineMapper(lineMapper())
                .targetType(EmailCampaignRecipientEntity.class)
                .build();
    }

    private LineMapper<EmailCampaignRecipientEntity> lineMapper() {

        DefaultLineMapper<EmailCampaignRecipientEntity> lineMapper =
                new DefaultLineMapper<>();

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        tokenizer.setNames("name", "email");
        tokenizer.setStrict(false);

        BeanWrapperFieldSetMapper<EmailCampaignRecipientEntity> fieldSetMapper =
                new BeanWrapperFieldSetMapper<>();

        fieldSetMapper.setTargetType(EmailCampaignRecipientEntity.class);

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }


    @Bean
    @StepScope
    public CampaignRecipientStoreProcessor processor(@Value("#{jobParameters['campaignId']}") String campaignId) {
        return new CampaignRecipientStoreProcessor(Integer.valueOf(campaignId));
    }


    @Bean
    RepositoryItemWriter<EmailCampaignRecipientEntity> writer(){

        RepositoryItemWriter<EmailCampaignRecipientEntity> writer = new RepositoryItemWriter<>(emailCampaignRecipientRepository);
        writer.setMethodName("save");
        return writer;
    }


    @Bean
    public Job job(JobRepository jobRepository, Step step){

        return new JobBuilder("emailRecipientCamp",jobRepository)
                .start(step).build();
    }


    @Bean
    public Step step(JobRepository jobRepository){
        return new StepBuilder("emailRecipientCampStep",jobRepository)
                .<EmailCampaignRecipientEntity,EmailCampaignRecipientEntity>chunk(100)
                .reader(campaignDataReader(null,null))
                .processor(processor(null))
                .writer(writer())
                .build();

    }
}
