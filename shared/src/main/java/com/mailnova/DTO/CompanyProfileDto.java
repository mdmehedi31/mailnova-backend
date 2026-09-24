package com.mailnova.DTO;

import java.time.LocalDateTime;

public class CompanyProfileDto extends AbstractId   implements GeneralApiResponse{

    private String name;
    private String companyEmail;
    private String fromEmailSendAddress;
    private String phoneNo;
    private String address;
    private String contactEmail;
    private LocalDateTime createdAt;
    private Integer createdBy;
    private String website;
    private Boolean status=true;
    private String colorCode;
    private String linkedinLink;
    private String fbLink;
    private String instaLink;
    private String tiktok;

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getFromEmailSendAddress() {
        return fromEmailSendAddress;
    }

    public void setFromEmailSendAddress(String fromEmailSendAddress) {
        this.fromEmailSendAddress = fromEmailSendAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public LocalDateTime getCreatedAt() {return createdAt;}

    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getFbLink() {
        return fbLink;
    }

    public void setFbLink(String fbLink) {
        this.fbLink = fbLink;
    }

    public String getInstaLink() {
        return instaLink;
    }

    public void setInstaLink(String instaLink) {
        this.instaLink = instaLink;
    }

    public String getTiktok() {
        return tiktok;
    }

    public void setTiktok(String tiktok) {
        this.tiktok = tiktok;
    }
}
