package com.mailnova.service.batch;


import com.mailnova.core.entity.EmailCampaignRecipientEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.infrastructure.item.ItemProcessor;


public class CampaignRecipientStoreProcessor implements ItemProcessor<EmailCampaignRecipientEntity, EmailCampaignRecipientEntity> {


    private Integer campaignId;
    private static final Logger log = LoggerFactory.getLogger(CampaignRecipientStoreProcessor.class);
    public CampaignRecipientStoreProcessor(Integer campaignId) {
        log.info("Constructor :: campaignId : {}", campaignId);
        this.campaignId = campaignId;
    }

    @Override
    public EmailCampaignRecipientEntity process(EmailCampaignRecipientEntity item) throws Exception {

        log.info("Processing item for campaign {}", campaignId);
        return item;
    }
}
