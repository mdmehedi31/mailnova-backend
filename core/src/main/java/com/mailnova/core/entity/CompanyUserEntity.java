package com.mailnova.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table
@Entity(name = "company_user")
public class CompanyUserEntity extends AbstractIdEntity{
    @Column(name = "company_id", nullable = false)
    private Integer companyId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
