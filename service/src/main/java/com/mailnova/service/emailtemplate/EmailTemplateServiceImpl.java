package com.mailnova.service.emailtemplate;

import com.mailnova.DTO.EmailTemplateDto;
import com.mailnova.core.dbservice.IEmailTemplateDBService;
import com.mailnova.core.entity.EmailTemplateEntity;
import com.mailnova.core.exceptionhandler.InvalidInputException;
import com.mailnova.core.exceptionhandler.NotFoundException;
import com.mailnova.exceptionmessage.ApiResponse;
import com.mailnova.service.mapper.EmailTemplateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmailTemplateServiceImpl implements IEmailTemplateService {


    private final IEmailTemplateDBService emailTemplateDBService;

    private final EmailTemplateMapper emailTemplateMapper;

    private static final Logger log = LoggerFactory.getLogger(EmailTemplateServiceImpl.class);

    public EmailTemplateServiceImpl(IEmailTemplateDBService emailTemplateDBService, EmailTemplateMapper emailTemplateMapper) {
        this.emailTemplateDBService = emailTemplateDBService;
        this.emailTemplateMapper = emailTemplateMapper;
    }

    @Override
    public EmailTemplateDto saveEmailTemplate(EmailTemplateDto emailTemplateDto) {
        try {

            if (emailTemplateDto.getTypeId() == null) {
                throw new InvalidInputException("Email template type cannot be empty");
            }

            if (emailTemplateDto.getName() == null || emailTemplateDto.getName().isBlank()) {
                throw new InvalidInputException("Email template name cannot be empty");
            }

            if (emailTemplateDto.getCreatedBy() == null) {
                throw new InvalidInputException("Email template creator cannot be empty");
            }

            EmailTemplateEntity isExist = emailTemplateDBService.getEmailTemplateByName(emailTemplateDto.getName(), emailTemplateDto.getCreatedBy());

            if (isExist != null) {
                return new EmailTemplateDto("Email template already exist with this name");
            }

            EmailTemplateEntity emailTemplateEntity = emailTemplateMapper.emailTemplateDtoToEntity(emailTemplateDto);
            emailTemplateEntity.setCreatedOn(LocalDateTime.now());
            emailTemplateEntity = emailTemplateDBService.saveEmailTemplate(emailTemplateEntity);
            if (emailTemplateEntity == null) {
                return new EmailTemplateDto("Email template not saved");
            }

            return emailTemplateMapper.entityToEmailTemplateDto(emailTemplateEntity);

        } catch (InvalidInputException e) {
            return new EmailTemplateDto(e.getMessage());
        } catch (Exception e) {
            log.error("An Exception thrown : ", e);
            return new EmailTemplateDto("Email template not saved, Service not available");
        }
    }

    @Override
    public EmailTemplateDto updateEmailTemplate(EmailTemplateDto emailTemplateDto) {

        try {
            if (emailTemplateDto.getTypeId() == null) {
                throw new InvalidInputException("Email template type cannot be empty");
            }

            if (emailTemplateDto.getName() == null || emailTemplateDto.getName().isBlank()) {
                throw new InvalidInputException("Email template name cannot be empty");
            }

            EmailTemplateEntity emailTemplateEntity = emailTemplateDBService.getEmailTemplate(emailTemplateDto.getId());

            if (emailTemplateEntity == null) {
                return new EmailTemplateDto("Email template not found");
            }


            EmailTemplateEntity isExist = emailTemplateDBService.getEmailTemplateByName(emailTemplateDto.getName(), emailTemplateDto.getCreatedBy());
            if (isExist != null && !emailTemplateDto.getId().equals(isExist.getId())) {
                return new EmailTemplateDto("Email template already exist with this name");
            }

            emailTemplateEntity = emailTemplateMapper.updateEmailTemplateDto(emailTemplateDto, emailTemplateEntity);

            emailTemplateEntity = emailTemplateDBService.saveEmailTemplate(emailTemplateEntity);

            if (emailTemplateEntity == null) {
                return new EmailTemplateDto("Email template not saved");
            }
            return emailTemplateMapper.entityToEmailTemplateDto(emailTemplateEntity);

        } catch (InvalidInputException e) {

            return new EmailTemplateDto(e.getMessage());
        } catch (Exception e) {
            log.error("An Exception thrown : ", e);
            return new EmailTemplateDto("Email template not saved, Service not available");
        }
    }

    @Override
    public EmailTemplateDto getEmailTemplate(Integer emailTemplateId) {
        try {
            EmailTemplateEntity emailTemplateEntity = emailTemplateDBService.getEmailTemplate(emailTemplateId);

            if (emailTemplateEntity == null) {
                throw new NotFoundException("Email template not found");
            }

            return emailTemplateMapper.entityToEmailTemplateDto(emailTemplateEntity);
        } catch (NotFoundException e) {
            return new EmailTemplateDto(e.getMessage());
        } catch (Exception e) {
            log.error("An Exception thrown : ", e);
            return new EmailTemplateDto("Email template not found, Service not available");
        }
    }

    @Override
    public List<EmailTemplateDto> getAllEmailTemplate(Integer createdById) {

        try {
            List<EmailTemplateEntity> emailTemplateEntities = emailTemplateDBService.getAllEmailTemplateByCreator(createdById);
            if (emailTemplateEntities == null) {
                return new ArrayList<>();
            }

            return emailTemplateMapper.entityToEmailTemplateDtoList(emailTemplateEntities);
        } catch (NotFoundException e) {
            log.error("An Exception thrown : ", e);
            return new ArrayList<>();
        } catch (Exception e) {
            log.error("An Exception thrown : ", e);
            return new ArrayList<>();
        }
    }

    @Override
    public ApiResponse deleteEmailTemplate(Integer emailTemplateId) {
        try {
            EmailTemplateEntity emailTemplateEntity = emailTemplateDBService.getEmailTemplate(emailTemplateId);
            if (emailTemplateEntity == null) {
                return new ApiResponse("Email template not found");
            }

            emailTemplateEntity.setIsDeleted(true);
            emailTemplateEntity = emailTemplateDBService.saveEmailTemplate(emailTemplateEntity);
            if (emailTemplateEntity == null) {
                return new ApiResponse("Email template not deleted");
            }
            return new ApiResponse("Email template deleted");

        } catch (Exception e) {
            log.error("An Exception thrown : ", e);
            return new ApiResponse("Not deleted, Service not available");
        }
    }
}
