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
}
