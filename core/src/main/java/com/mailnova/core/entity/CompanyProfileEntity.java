package com.mailnova.core.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_comp_profile")
public class CompanyProfileEntity extends AbstractIdEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "email_send_add")
    private String fromEmailSendAddress;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "website")
    private String website;

    @Column(name = "color_code")
    private String colorCode;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @Column(name = "fb_link")
    private String fbLink;

    @Column(name = "insta_link")
    private String instaLink;

    @Column(name = "tiktok")
    private String tiktok;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
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
