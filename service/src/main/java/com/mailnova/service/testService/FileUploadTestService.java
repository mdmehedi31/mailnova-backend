package com.mailnova.service.testService;


import com.mailnova.DTO.EmailCampaignRecipientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileUploadTestService {


    private static final Logger log = LoggerFactory.getLogger(FileUploadTestService.class);



    private JobOperator jobOperator;
    private Job job;

    public FileUploadTestService(JobOperator jobOperator, Job job) {
        this.jobOperator = jobOperator;
        this.job = job;
    }

    public String uploadFile(EmailCampaignRecipientDto emailCampaignRecipientDto){
        try{
            Integer campaignId=emailCampaignRecipientDto.getEmailCampaignId();
            MultipartFile campaignFile=emailCampaignRecipientDto.getAttachment();

            Path path = saveTempFile(campaignFile,campaignId.toString());

            log.info("Path is : {}",path != null?path.toString():"Path not available");
            if (path != null) {

                JobParameters parameters = new JobParametersBuilder().
                        addString("jobName", "csvUploadAndParseTest").
                        addString("campaignId", campaignId.toString()).
                        addString("filePath", path.toString()).
                        toJobParameters();

                jobOperator.start(job, parameters);

                return "Upload Success";

            }
        return "Upload Failed";
        }catch (Exception e){
            log.error("An exception thrown : ",e);

            return "Upload Failed";
        }
    }

    public Path saveTempFile(MultipartFile file, String campaignId) throws IOException {

        try{
            Path tempFile = Files.createTempFile(
                    "mailnova-campaign-"+campaignId,
                    ".csv"
            );

            file.transferTo(tempFile);

            return tempFile;
        }catch (Exception e){
            log.error("An exception thrown : ",e);
            return null;
        }

    }
}
