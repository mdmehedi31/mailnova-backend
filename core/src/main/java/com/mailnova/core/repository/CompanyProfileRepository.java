package com.mailnova.core.repository;

import com.mailnova.core.entity.CompanyProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfileEntity, Integer> {
    List<CompanyProfileEntity> findAllByCreatedByAndIsDeletedIsNullOrIsDeleted(Integer userId, boolean isDeleted);
}
