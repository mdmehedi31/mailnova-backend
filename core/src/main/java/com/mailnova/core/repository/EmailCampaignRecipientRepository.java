package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailCampaignRecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailCampaignRecipientRepository extends JpaRepository<EmailCampaignRecipientEntity,Integer> {
}
