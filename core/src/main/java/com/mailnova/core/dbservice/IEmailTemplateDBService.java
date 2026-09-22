package com.mailnova.core.dbservice;


import com.mailnova.core.entity.EmailTemplateEntity;

import java.util.List;

public interface IEmailTemplateDBService {

    public EmailTemplateEntity saveEmailTemplate(EmailTemplateEntity emailTemplate);
    public EmailTemplateEntity getEmailTemplate(int id);
    public List<EmailTemplateEntity> getAllEmailTemplateByCreator(Integer creatorId);
    public EmailTemplateEntity getEmailTemplateByName(String templateName, Integer creatorId);
}
