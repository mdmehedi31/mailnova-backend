package com.mailnova.core.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class CompanyProfileEntity extends AbstractIdEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "email_send_add")
    private String fromEmailSendAdd;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_email")
    private String contactEmail;

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

    public String getFromEmailSendAdd() {
        return fromEmailSendAdd;
    }

    public void setFromEmailSendAdd(String fromEmailSendAdd) {
        this.fromEmailSendAdd = fromEmailSendAdd;
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
}
