package com.mailnova.service.batch;


import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.Date;

@Component
public class EmailSentSchedulerRunner {

    @Autowired
    private Scheduler scheduler;

    private static final Logger log = LoggerFactory.getLogger(EmailSentSchedulerRunner.class);

    public void setEmailSchedule(Integer campaignId, Instant scheduleTime, String timeZone) {
        try {
            String jobKey = "campaign-job-" + campaignId;
            String triggerKey = "campaign-trigger-" + campaignId;

            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("campaignId", String.valueOf(campaignId));

           /* LocalDateTime dateTime = LocalDateTime.of(
                    LocalDate.now(),
                    LocalTime.of(12, 18)
            );
            ZoneId zoneId = ZoneId.of("Asia/Dhaka");

            Instant instant = dateTime
                    .atZone(zoneId)
                    .toInstant();*/

            log.info("Scheduled time: " + scheduleTime);
            JobDetail jobDetail = JobBuilder
                    .newJob(EmailSentQuartzScheduler.class)
                    .withIdentity(jobKey, "campaign-group")
                    .usingJobData(jobDataMap)
                    .build();

            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity(triggerKey, "campaign-group")
                    .forJob(jobDetail)
                    .startAt(Date.from(scheduleTime))
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);

            log.info(
                    "Campaign scheduled | campaignId={} | job={} | trigger={} | fireTime={}",
                    campaignId,
                    jobDetail.getKey(),
                    trigger.getKey(),
                    trigger.getNextFireTime()
            );

        } catch (Exception e) {
            log.error(
                    "Failed to schedule campaign {}",
                    campaignId,
                    e
            );
        }
    }


}
