package com.mailnova.core.dbservice;

import com.mailnova.core.entity.EmailCampaignEntity;

public interface IEmailCampaignDBService {
    public EmailCampaignEntity save(EmailCampaignEntity emailCampaign);
    public EmailCampaignEntity findById(Integer id);
    public EmailCampaignEntity findByNameAndCreatedBy(String name, Integer createdBy);

}
