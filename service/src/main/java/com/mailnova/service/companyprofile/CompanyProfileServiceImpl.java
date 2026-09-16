package com.mailnova.service.companyprofile;


import com.mailnova.DTO.CompanyProfileDto;
import com.mailnova.DTO.GeneralApiResponse;
import com.mailnova.core.dbservice.ICompanyProfileDBService;
import com.mailnova.core.entity.CompanyProfileEntity;
import com.mailnova.core.exceptionhandler.InvalidInputException;
import com.mailnova.core.exceptionhandler.NotFoundException;
import com.mailnova.exceptionmessage.ApiResponse;
import com.mailnova.service.mapper.CompanyProfileMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyProfileServiceImpl implements ICompanyProfileService {


    private final CompanyProfileMapper companyProfileMapper;
    private final ICompanyProfileDBService companyProfileDBService;

    private static final Logger log = LoggerFactory.getLogger(CompanyProfileServiceImpl.class);

    public CompanyProfileServiceImpl(CompanyProfileMapper companyProfileMapper,
                                     ICompanyProfileDBService companyProfileDBService) {
        this.companyProfileMapper = companyProfileMapper;
        this.companyProfileDBService = companyProfileDBService;
    }

    @Override
    public GeneralApiResponse createOrModifyCompanyProfile(CompanyProfileDto companyProfileDto) {
        try {

            log.info("Create or modify company profile :::");

            CompanyProfileEntity companyProfileEntity = null;
            if (companyProfileDto.getId() != null) {
                // If not found the throws exception
                companyProfileEntity = companyProfileDBService.getCompanyProfileById(companyProfileDto.getId());

                log.info("DTO Company email : {}, Entity comapny email : {}", companyProfileDto.getCompanyEmail(), companyProfileEntity.getCompanyEmail());
                log.info("DTO From Email Address : {}, Entity From Email Address : {}", companyProfileDto.getFromEmailSendAddress(), companyProfileEntity.getFromEmailSendAddress());
                if (companyProfileEntity != null) {
                    if (companyProfileDto.getCompanyEmail() != null && !companyProfileDto.getCompanyEmail().equals(companyProfileEntity.getCompanyEmail())) {
                       log.info("Company email try to update");
                        ApiResponse response = companyInfoValidationCheck(companyProfileDto, false);
                        if (response != null) return response;
                    }

                    if (companyProfileEntity.getFromEmailSendAddress() != null && companyProfileDto.getFromEmailSendAddress() != null
                            && !companyProfileDto.getFromEmailSendAddress().equals(companyProfileEntity.getFromEmailSendAddress())) {
                       log.info("From Email Address try to update");
                        ApiResponse response = companyInfoValidationCheck(companyProfileDto, true);
                        if (response != null) return response;
                    }

                    companyProfileMapper.updateEntityFromDto(companyProfileDto, companyProfileEntity);
                } else {
                    throw new NotFoundException("Company profile not found with this id");
                }
            } else {

                if (companyProfileDto.getName() == null)
                    throw new InvalidInputException("Company name cannot be empty");

                if (companyProfileDto.getCompanyEmail() == null)
                    throw new InvalidInputException("Company email cannot be empty");

                ApiResponse response = companyInfoValidationCheck(companyProfileDto, false);
                if (response != null) return response;

                ApiResponse fromEmailValidation = companyInfoValidationCheck(companyProfileDto, true);
                if (fromEmailValidation != null) return fromEmailValidation;


                companyProfileDto.setCreatedAt(LocalDateTime.now());
                companyProfileEntity = companyProfileMapper.dtoToEntity(companyProfileDto);
            }

            if (companyProfileEntity != null) {
                CompanyProfileEntity saveResponse = this.companyProfileDBService.saveCompanyProfile(companyProfileEntity);
                return companyProfileMapper.entityToDto(saveResponse);
            }
            return null;

        } catch (InvalidInputException e) {
            log.error("An exception thrown ", e);
            throw e;
        } catch (NotFoundException exception) {
            log.error("An exception thrown ", exception);
            throw exception;
        } catch (Exception e) {
            log.error("An Exception thrown : ", e);
            throw e;
        }
    }

    private ApiResponse companyInfoValidationCheck(CompanyProfileDto companyProfileDto, boolean isFromEmailSendAddress) {


        if (!isFromEmailSendAddress) {
            log.info("Company email try to update :: validation checking... ");
            CompanyProfileEntity companyEmailExist = this.companyProfileDBService.getCompanyProfileByEmail(companyProfileDto.getCompanyEmail());
            if (companyEmailExist != null) {
                return new ApiResponse("Company already exist with this email");
            }
        }

        if (companyProfileDto.getFromEmailSendAddress() != null) {
            log.info("From Email Address try to update:: validation");
            CompanyProfileEntity companyEmailExist = this.companyProfileDBService.getCompanyProfileByFromEmailAddress(companyProfileDto.getFromEmailSendAddress());
            if (companyEmailExist != null) {
                return new ApiResponse("Company already exist with this email send address");
            }
        }

        return null;
    }

    @Override
    public List<CompanyProfileDto> getCompanyProfilesByUserId(Integer userId) {
        try {

            List<CompanyProfileEntity> companyProfileEntities = this.companyProfileDBService.getAllCompanyProfilesByUserId(userId);

            if (companyProfileEntities != null && companyProfileEntities.size() > 0) {
                return companyProfileMapper.entitesToDtos(companyProfileEntities);
            }
            return new ArrayList<>();
        } catch (Exception e) {
            log.error("An exception thrown ", e);
            return new ArrayList<>();
        }
    }

    @Override
    public GeneralApiResponse getCompanyProfileById(Integer companyProfileId) {

        try {

            CompanyProfileEntity companyProfileEntity = this.companyProfileDBService.getCompanyProfileById(companyProfileId);

            if (companyProfileEntity != null) {
                return companyProfileMapper.entityToDto(companyProfileEntity);
            } else {
                return new ApiResponse("Company profile not found with this id");
            }
        } catch (Exception e) {
            log.error("An exception thrown ", e);
            return new ApiResponse("Service not available, will back soon");
        }
    }

    @Override
    public ApiResponse deleteCompanyProfile(Integer companyProfileId) {
        ApiResponse apiResponse = new ApiResponse();
        try {

            CompanyProfileEntity companyProfileEntity = this.companyProfileDBService.getCompanyProfileById(companyProfileId);
            if (companyProfileEntity != null) {
                companyProfileEntity.setDeleted(true);
                this.companyProfileDBService.saveCompanyProfile(companyProfileEntity);
                apiResponse.setMessage("Deleted company profile successfully");
            } else {
                apiResponse.setMessage("Company profile not found");
            }
            return apiResponse;
        } catch (Exception e) {
            log.error("An exception thrown ", e);
            return new ApiResponse("This service is unavailable,we will back soon");
        }
    }
}
