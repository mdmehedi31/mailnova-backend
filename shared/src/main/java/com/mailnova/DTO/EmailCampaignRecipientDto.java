package com.mailnova.DTO;

import java.time.LocalDateTime;

public class EmailCampaignRecipientDto extends AbstractId{

    private Integer emailCampaignId;
    private String email;
    private LocalDateTime emailAddedAt;
    private String deliveryStatus;
    private String deliveryFailedReason;
    private LocalDateTime openedAt;
    private Integer readCount;

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
}
