package com.mailnova.DTO;

public class EmailCampaignTemplateDto extends AbstractId{
    private Integer emailCampaignId;
    private Integer emailTemplateId;

    public Integer getEmailCampaignId() {
        return emailCampaignId;
    }

    public void setEmailCampaignId(Integer emailCampaignId) {
        this.emailCampaignId = emailCampaignId;
    }

    public Integer getEmailTemplateId() {
        return emailTemplateId;
    }

    public void setEmailTemplateId(Integer emailTemplateId) {
        this.emailTemplateId = emailTemplateId;
    }
}
