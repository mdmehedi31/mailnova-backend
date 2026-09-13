package com.mailnova.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "email_campaign_template")
public class EmailCampaignTemplateEntity extends AbstractIdEntity{

    @Column(name = "email_campaign_id")
    private Integer emailCampaignId;

    @Column(name = "email_template_id")
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
