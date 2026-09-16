package com.mailnova.service.companyprofile;

import com.mailnova.DTO.CompanyProfileDto;
import com.mailnova.DTO.GeneralApiResponse;
import com.mailnova.exceptionmessage.ApiResponse;

import java.util.List;

public interface ICompanyProfileService {

    public GeneralApiResponse createOrModifyCompanyProfile(CompanyProfileDto companyProfileDto);
    public List<CompanyProfileDto> getCompanyProfilesByUserId(Integer userId);
    public GeneralApiResponse getCompanyProfileById(Integer companyProfileId);
    public ApiResponse deleteCompanyProfile(Integer companyProfileId);

}
