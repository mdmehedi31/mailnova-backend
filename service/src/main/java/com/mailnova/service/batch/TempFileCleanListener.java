package com.mailnova.service.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.job.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListener;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;


@Component
public class TempFileCleanListener implements JobExecutionListener  {


    private static final Logger log = LoggerFactory.getLogger(TempFileCleanListener.class);
    @Override
    public void afterJob(JobExecution jobExecution) {
        try{

            log.info("Cleaning temp file");
            String filePath = jobExecution.getJobParameters().getString("filePath");

            if (filePath != null) {
                return;
            }

            Files.delete(Path.of(filePath));

            System.out.println("Temp file deleted: " + filePath);

        }catch (Exception e){
            log.error("An exception thrown : ",e);
        }

        JobExecutionListener.super.afterJob(jobExecution);
    }
}
