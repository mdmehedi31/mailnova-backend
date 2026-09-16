package com.mailnova.service.companyprofile;


import com.mailnova.DTO.CompanyProfileDto;
import com.mailnova.core.dbservice.ICompanyProfileDBService;
import com.mailnova.core.entity.CompanyProfileEntity;
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
    public CompanyProfileDto createOrModifyCompanyProfile(CompanyProfileDto companyProfileDto) {
        try{

            log.debug("Create or modify company profile :::");

            if(companyProfileDto.getId() !=null){
                // If not found the throws exception
                companyProfileDBService.getCompanyProfileById(companyProfileDto.getId());
            }
            companyProfileDto.setCreatedAt(LocalDateTime.now());
           CompanyProfileEntity companyProfileEntity = companyProfileMapper.dtoToEntity(companyProfileDto);

            if(companyProfileEntity != null){
                CompanyProfileEntity saveResponse= this.companyProfileDBService.saveCompanyProfile(companyProfileEntity);
                return companyProfileMapper.entityToDto(saveResponse);
            }
            return null;

        }catch (NotFoundException exception){
            log.error("An exception thrown ",exception);
            return null;
        }
        catch (Exception e){
            log.error("An Exception thrown : ",e);
            return null;
        }
    }

    @Override
    public List<CompanyProfileDto> getCompanyProfilesByUserId(Integer userId) {
        try {

            List<CompanyProfileEntity> companyProfileEntities = this.companyProfileDBService.getAllCompanyProfilesByUserId(userId);

            if(companyProfileEntities != null && companyProfileEntities.size() > 0){
                return companyProfileMapper.entitesToDtos(companyProfileEntities);
            }
            return new ArrayList<>();
        }catch (Exception e){
            log.error("An exception thrown ",e);
            return new ArrayList<>();
        }
    }

    @Override
    public CompanyProfileDto getCompanyProfileById(Integer companyProfileId) {
        return null;
    }

    @Override
    public ApiResponse deleteCompanyProfile(Integer companyProfileId) {
        return null;
    }
}
