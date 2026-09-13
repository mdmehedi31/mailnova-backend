package com.mailnova.core.repository;

import com.mailnova.core.entity.CompanyUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyUserRepository extends JpaRepository<CompanyUserEntity, Integer> {
}
