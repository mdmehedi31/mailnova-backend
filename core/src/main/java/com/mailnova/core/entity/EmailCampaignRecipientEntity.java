package com.mailnova.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "email_campaign_recipient")
public class EmailCampaignRecipientEntity extends AbstractIdEntity{

    @Column(name = "email_campaign_id")
    private Integer emailCampaignId;

    @Column(name = "email")
    private String email;

    @Column(name = "email_added_at")
    private LocalDateTime emailAddedAt;

    @Column(name = "delivery_status")
    private String deliveryStatus = "PENDING";

    @Column(name = "delivery_failed_reason")
    private String deliveryFailedReason;

    @Column(name = "opened_at")
    private LocalDateTime openedAt;

    @Column(name = "read_count")
    private Integer readCount = 0;

    @Column(name = "name")
    private String name;

    public Integer getEmailCampaignId() {
        return emailCampaignId;
    }

    public void setEmailCampaignId(Integer emailCampaignId) {
        this.emailCampaignId = emailCampaignId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getEmailAddedAt() {
        return emailAddedAt;
    }

    public void setEmailAddedAt(LocalDateTime emailAddedAt) {
        this.emailAddedAt = emailAddedAt;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryFailedReason() {
        return deliveryFailedReason;
    }

    public void setDeliveryFailedReason(String deliveryFailedReason) {
        this.deliveryFailedReason = deliveryFailedReason;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(LocalDateTime openedAt) {
        this.openedAt = openedAt;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
