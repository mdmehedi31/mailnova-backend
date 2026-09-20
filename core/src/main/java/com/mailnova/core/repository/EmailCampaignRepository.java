package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailCampaignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;

public interface EmailCampaignRepository extends JpaRepository<EmailCampaignEntity,Integer> {
    EmailCampaignEntity findByIdAndCancelledOnIsNull(Integer id, Instant cancelledOn);

    EmailCampaignEntity findByNameAndCreatedBy(String name, Integer createdBy);

    @Query("select e from EmailCampaignEntity e where e.id=:id and e.cancelledOn is null and (e.isDeleted is null or e.isDeleted=false)")
    EmailCampaignEntity findByIdAndCancelledOnIsNullAndIsDeletedIsNullOrIsDeleted(Integer id);
}
