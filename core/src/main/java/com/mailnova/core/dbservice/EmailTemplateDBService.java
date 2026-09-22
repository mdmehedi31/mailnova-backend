package com.mailnova.core.dbservice;


import com.mailnova.core.entity.EmailTemplateEntity;
import com.mailnova.core.repository.EmailTemplateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailTemplateDBService implements IEmailTemplateDBService {

    private EmailTemplateRepository emailTemplateRepository;

    private static Logger log = LoggerFactory.getLogger(EmailTemplateDBService.class);

    public EmailTemplateDBService(EmailTemplateRepository emailTemplateRepository) {
        this.emailTemplateRepository = emailTemplateRepository;
    }

    @Override
    public EmailTemplateEntity saveEmailTemplate(EmailTemplateEntity emailTemplate) {
        try {
            return emailTemplateRepository.save(emailTemplate);
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EmailTemplateEntity getEmailTemplate(int emailTemplateId) {
        try{
            return emailTemplateRepository.findByIdAndIsDeletedIsNullOrIsDeleted(emailTemplateId);
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<EmailTemplateEntity> getAllEmailTemplateByCreator(Integer creatorId) {

        try{
            return emailTemplateRepository.findAllByCreatedBy( creatorId );
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EmailTemplateEntity getEmailTemplateByName(String templateName, Integer creatorId) {
        try{
            return emailTemplateRepository.findByNameAndCreatedBy(templateName, creatorId);
        }catch (Exception e) {
            throw e;
        }
    }
}
