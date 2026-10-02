package com.mailnova.service.batch;

import com.mailnova.core.entity.EmailCampaignRecipientEntity;
import com.mailnova.enums.CampaignStatus;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import java.time.LocalDateTime;


public class CampaignRecipientStoreProcessor implements ItemProcessor<EmailCampaignRecipientEntity, EmailCampaignRecipientEntity> {


    private Integer campaignId;

    public CampaignRecipientStoreProcessor(Integer campaignId) {
        this.campaignId = campaignId;
    }

    @Override
    public EmailCampaignRecipientEntity process(EmailCampaignRecipientEntity item) throws Exception {
        item.setDeliveryStatus(CampaignStatus.CREATED.name());
        item.setEmailCampaignId(campaignId);
        item.setEmailAddedAt(LocalDateTime.now());

        return item;
    }
}
