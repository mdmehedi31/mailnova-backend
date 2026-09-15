package com.mailnova.service.companyprofile;

import com.mailnova.DTO.CompanyProfileDto;
import com.mailnova.exceptionmessage.ApiResponse;

import java.util.List;

public interface ICompanyProfileService {

    public CompanyProfileDto createOrModifyCompanyProfile(CompanyProfileDto companyProfileDto);
    public List<CompanyProfileDto> getCompanyProfilesByUserId(Integer userId);
    public CompanyProfileDto getCompanyProfileById(Integer companyProfileId);
    public ApiResponse deleteCompanyProfile(Integer companyProfileId);

}
