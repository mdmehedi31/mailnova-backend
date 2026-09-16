package com.mailnova.core.dbservice;


import com.mailnova.core.entity.CompanyProfileEntity;
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
           Optional<CompanyProfileEntity> companyProfileEntity = this.companyProfileRepository.findByIdAndIsDeletedIsNullOrIsDeleted(companyProfileId,false);

           if(!companyProfileEntity.isPresent()) {
               return null;
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

        try{
            return this.companyProfileRepository.findAllByCreatedByAndIsDeletedIsNullOrIsDeleted(userId, false);
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public CompanyProfileEntity getCompanyProfileByEmail(String companyEmail) {
        try{
            return  this.companyProfileRepository.findByCompanyEmailAndIsDeletedIsNullOrIsDeleted(companyEmail,false);
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public CompanyProfileEntity getCompanyProfileByFromEmailAddress(String fromEmailAddress) {
        try {
            return this.companyProfileRepository.findByFromEmailSendAddressAndIsDeletedIsNullOrIsDeleted(fromEmailAddress,false);
        }catch (Exception e) {
            throw e;
        }
    }
}
