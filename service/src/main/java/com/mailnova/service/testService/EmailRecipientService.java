package com.mailnova.service.testService;

import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.enums.Response;
import com.mailnova.exceptionmessage.ApiResponse;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.jdbc.core.JdbcTemplate;

@EnableAsync
@Service
public class EmailRecipientService {


    private static final Logger log = LoggerFactory.getLogger(EmailRecipientService.class);


    private JdbcTemplate jdbcTemplate;
    private JobOperator jobOperator;
    private Job job;

    public EmailRecipientService(JobOperator jobOperator, Job job, JdbcTemplate jdbcTemplate) {
        this.jobOperator = jobOperator;
        this.job = job;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Async
    public void uploadFile(EmailCampaignRecipientDto emailCampaignRecipientDto) {
        try {
            Integer campaignId = emailCampaignRecipientDto.getEmailCampaignId();
            MultipartFile campaignFile = emailCampaignRecipientDto.getAttachment();

            Path path = saveTempFile(campaignFile, campaignId.toString());

            log.info("Path is : {}", path != null ? path.toString() : "Path not available");
            if (path != null) {

                /*JobParameters parameters = new JobParametersBuilder().
                        addString("jobName", "csvUploadAndParseTest").
                        addString("campaignId", campaignId.toString()).
                        addString("filePath", path.toString()).
                        toJobParameters();

                jobOperator.start(job, parameters);*/
                Long startTime = System.currentTimeMillis();
                LocalDateTime dateTimeStart = Instant.ofEpochSecond(startTime)
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                log.info("Starting ::: Start time : {}", dateTimeStart);
               boolean isUploaded = uploadFile(path, campaignId);

                Long endTime = System.currentTimeMillis();

                LocalDateTime dateTimeEnd = Instant.ofEpochSecond(endTime)
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                System.out.println("Start time : "+dateTimeStart+" and end time : "+dateTimeEnd);
               if (isUploaded) {
                   log.info("Uploaded email successfully....");
                   //return new ApiResponse(Response.SUCCESS.name());
               }

              //  return new ApiResponse(Response.FAILED.name());

            }
           // return new ApiResponse(Response.FAILED.name());
        } catch (Exception e) {
            log.error("An exception thrown : ", e);

          //  return new ApiResponse(Response.FAILED.name());
        }
    }

    public Path saveTempFile(MultipartFile file, String campaignId) throws IOException {

        try {
            Path tempFile = Files.createTempFile(
                    "mailnova-campaign-" + campaignId,
                    ".csv"
            );

            file.transferTo(tempFile);

            return tempFile;
        } catch (Exception e) {
            log.error("An exception thrown : ", e);
            return null;
        }

    }


    @Transactional(rollbackOn = {Exception.class, RuntimeException.class, IOException.class})
    public boolean uploadFile(Path csvFilePath, Integer campaignId) {
        try {


            String filePath = csvFilePath
                    .toAbsolutePath()
                    .toString()
                    .replace("\\", "/");

            String sql = """
                    LOAD DATA LOCAL INFILE '%s'
                    INTO TABLE email_campaign_recipient
                    FIELDS TERMINATED BY ','
                    OPTIONALLY ENCLOSED BY '"'
                    LINES TERMINATED BY '\\n'
                    IGNORE 1 ROWS
                    (name, email)
                    SET
                        email_campaign_id = %d,
                        email_added_at = NOW(),
                        delivery_status = 'CREATED'
                    """.formatted(
                    filePath.replace("'", "''"),
                    campaignId
            );

            jdbcTemplate.execute(sql);

            boolean deleteIfExists = Files.deleteIfExists(csvFilePath);

            log.info("Deleted file exist : {}", deleteIfExists);
            return true;

        }catch (IOException exception){

            log.error("An exception thrown (IO): ", exception);
            return false;
        }
        catch (Exception e) {
            log.error("An exception thrown : ", e);
            return false;
        }
    }
}
