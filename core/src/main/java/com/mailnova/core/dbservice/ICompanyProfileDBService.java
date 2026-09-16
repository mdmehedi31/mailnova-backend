package com.mailnova.core.dbservice;

import com.mailnova.core.entity.CompanyProfileEntity;

import java.util.List;

public interface ICompanyProfileDBService {

    public CompanyProfileEntity getCompanyProfileById(Integer companyProfileId);
    public CompanyProfileEntity saveCompanyProfile(CompanyProfileEntity companyProfile);
    public List<CompanyProfileEntity> getAllCompanyProfilesByUserId(Integer userId);
    public CompanyProfileEntity getCompanyProfileByEmail(String companyEmail);
    public CompanyProfileEntity getCompanyProfileByFromEmailAddress(String fromEmailAddress);
}
