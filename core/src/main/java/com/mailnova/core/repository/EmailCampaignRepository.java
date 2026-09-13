package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailCampaignEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailCampaignRepository extends JpaRepository<EmailCampaignEntity,Integer> {
}
