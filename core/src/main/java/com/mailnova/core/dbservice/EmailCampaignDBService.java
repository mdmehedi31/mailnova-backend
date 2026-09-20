package com.mailnova.core.dbservice;


import com.mailnova.core.entity.EmailCampaignEntity;
import com.mailnova.core.repository.EmailCampaignRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailCampaignDBService implements IEmailCampaignDBService {

    private  final EmailCampaignRepository emailCampaignRepository;

    public EmailCampaignDBService(EmailCampaignRepository emailCampaignRepository) {
        this.emailCampaignRepository = emailCampaignRepository;
    }


    @Override
    public EmailCampaignEntity save(EmailCampaignEntity emailCampaign) {
        try {
            return this.emailCampaignRepository.save(emailCampaign);
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EmailCampaignEntity findById(Integer id) {
        try{
            return this.emailCampaignRepository.findByIdAndCancelledOnIsNullAndIsDeletedIsNullOrIsDeleted(id);
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EmailCampaignEntity findByNameAndCreatedBy(String name, Integer createdBy) {

        try{
            return this.emailCampaignRepository.findByNameAndCreatedBy(name, createdBy);
        }catch (Exception e) {
            throw e;
        }
    }
}
