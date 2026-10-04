package com.mailnova.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mailnova.exceptionmessage.ApiResponse;

import java.time.Instant;
import java.time.LocalDateTime;

public class EmailCampaignDto extends ApiResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createdOn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer createdBy;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Instant sendScheduleDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String timezone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Instant startedOn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Instant completedOn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Instant cancelledOn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String failureReason;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer companyId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tags;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String campaignType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer emailTemplateId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String repliedTo;

    public EmailCampaignDto(String message) {
        super(message);
    }

    public EmailCampaignDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getSendScheduleDate() {
        return sendScheduleDate;
    }

    public void setSendScheduleDate(Instant sendScheduleDate) {
        this.sendScheduleDate = sendScheduleDate;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(Instant startedOn) {
        this.startedOn = startedOn;
    }

    public Instant getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(Instant completedOn) {
        this.completedOn = completedOn;
    }

    public Instant getCancelledOn() {
        return cancelledOn;
    }

    public void setCancelledOn(Instant cancelledOn) {
        this.cancelledOn = cancelledOn;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }

    public Integer getEmailTemplateId() {
        return emailTemplateId;
    }

    public void setEmailTemplateId(Integer emailTemplateId) {
        this.emailTemplateId = emailTemplateId;
    }

    public String getRepliedTo() {
        return repliedTo;
    }

    public void setRepliedTo(String repliedTo) {
        this.repliedTo = repliedTo;
    }

}
