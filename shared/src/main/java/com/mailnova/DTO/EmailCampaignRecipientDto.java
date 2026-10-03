package com.mailnova.DTO;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public class EmailCampaignRecipientDto extends AbstractId{

    private Integer emailCampaignId;
    private String email;
    private LocalDateTime emailAddedAt;
    private String deliveryStatus;
    private String deliveryFailedReason;
    private LocalDateTime openedAt;
    private Integer readCount;
    private String name;
    private MultipartFile attachment;
    private List<EmailRecipientDTO> emailRecipients;

    public EmailCampaignRecipientDto() {
    }

    public EmailCampaignRecipientDto(Integer id, String email, String name) {
        super(id);
        this.email = email;
        this.name = name;
    }

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

    public MultipartFile getAttachment() {
        return attachment;
    }

    public void setAttachment(MultipartFile attachment) {
        this.attachment = attachment;
    }

    public List<EmailRecipientDTO> getEmailRecipients() {
        return emailRecipients;
    }

    public void setEmailRecipients(List<EmailRecipientDTO> emailRecipients) {
        this.emailRecipients = emailRecipients;
    }
}
