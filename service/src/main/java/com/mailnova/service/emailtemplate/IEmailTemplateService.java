package com.mailnova.service.emailtemplate;

import com.mailnova.DTO.EmailTemplateDto;
import com.mailnova.exceptionmessage.ApiResponse;

import java.util.List;

public interface IEmailTemplateService {

    public EmailTemplateDto saveEmailTemplate(EmailTemplateDto emailTemplateDto);
    public EmailTemplateDto updateEmailTemplate(EmailTemplateDto emailTemplateDto);
    public EmailTemplateDto getEmailTemplate(Integer emailTemplateId);
    public List<EmailTemplateDto> getAllEmailTemplate(Integer createdById);
    public ApiResponse deleteEmailTemplate(Integer emailTemplateId);

}
