package com.mailnova.core.repository;

import com.mailnova.core.entity.CompanyProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfileEntity, Integer> {
    List<CompanyProfileEntity> findAllByCreatedByAndIsDeletedIsNullOrIsDeleted(Integer userId, boolean isDeleted);

    CompanyProfileEntity findByCompanyEmail(String companyEmail);

    CompanyProfileEntity findByFromEmailSendAddress(String fromEmailAddress);

    Optional<CompanyProfileEntity> findByIdAndIsDeletedIsNullOrIsDeleted(Integer companyProfileId, boolean isDeleted);

    CompanyProfileEntity findByCompanyEmailAndIsDeletedIsNullOrIsDeleted(String companyEmail, boolean isDeleted);

    CompanyProfileEntity findByFromEmailSendAddressAndIsDeletedIsNullOrIsDeleted(String fromEmailSendAddress, Boolean isDeleted);
}
