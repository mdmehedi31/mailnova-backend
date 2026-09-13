package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailCampaignTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailCampaignTemplateRepository extends JpaRepository<EmailCampaignTemplateEntity, Integer> {
}
