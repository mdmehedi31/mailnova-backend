package com.mailnova.core.dbservice;


import com.mailnova.core.entity.CompanyProfileEntity;
import com.mailnova.core.exceptionhandler.NotFoundException;
import com.mailnova.core.repository.CompanyProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyProfileDBService implements ICompanyProfileDBService {

    private final CompanyProfileRepository companyProfileRepository;

    public CompanyProfileDBService(CompanyProfileRepository companyProfileRepository) {
        this.companyProfileRepository = companyProfileRepository;
    }

    @Override
    public CompanyProfileEntity getCompanyProfileById(Integer companyProfileId) {

        try {
           Optional<CompanyProfileEntity> companyProfileEntity = this.companyProfileRepository.findById(companyProfileId);

           if(!companyProfileEntity.isPresent()) {
               throw new NotFoundException("Company Profile Not Found");
           }
            return companyProfileEntity.get();
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public CompanyProfileEntity saveCompanyProfile(CompanyProfileEntity companyProfile) {
        try{
            return this.companyProfileRepository.save(companyProfile);
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<CompanyProfileEntity> getAllCompanyProfilesByUserId(Integer userId) {

        return List.of();
    }
}
