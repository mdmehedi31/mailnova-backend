package com.mailnova.core.repository;

import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.core.entity.EmailFilterRecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmailFilterRecipientRepository extends JpaRepository<EmailFilterRecipientEntity,Integer> {

    @Query("""
    SELECT  new com.mailnova.DTO.EmailCampaignRecipientDto(
    e.id,
    e.email,
    e.name
    ) from EmailCampaignRecipientEntity e inner join
    EmailFilterRecipientEntity  fr on e.id= fr.recipientEmailId
    where fr.filterEmailColId=:filterEmailColId
""")
    List<EmailCampaignRecipientDto> findAllByFilterEmailColId(Integer filterEmailColId);

    void deleteAllByFilterEmailColId(Integer filterEmailColId);
}
