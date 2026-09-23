package com.mailnova.service.emailfilter;


import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.DTO.EmailFilterDTO;
import com.mailnova.core.dbservice.IEmailFilterDBService;
import com.mailnova.core.entity.EmailFilterEntity;
import com.mailnova.core.exceptionhandler.InvalidInputException;
import com.mailnova.service.mapper.EmailFilterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailFilterServiceImpl implements IEmailFilterService {

    private final IEmailFilterDBService emailFilterDBService;

    private static final Logger log = LoggerFactory.getLogger(EmailFilterServiceImpl.class);
    private final EmailFilterMapper emailFilterMapper;

    public EmailFilterServiceImpl(IEmailFilterDBService emailFilterDBService, EmailFilterMapper emailFilterMapper) {
        this.emailFilterDBService = emailFilterDBService;
        this.emailFilterMapper = emailFilterMapper;
    }

    @Override
    public EmailFilterDTO createEmailFilter(EmailFilterDTO emailFilterDTO) {
        try {

            if (emailFilterDTO.getName() == null || emailFilterDTO.getName().isBlank()) {
                throw new InvalidInputException("Email Filter name cannot be empty");
            }
            if (emailFilterDTO.getCreatedBy() == null) {
                throw new InvalidInputException("Email Filter createdBy cannot be empty");
            }

            EmailFilterEntity emailFilterEntity = emailFilterDBService.getEmailFilterByName(emailFilterDTO.getName(), emailFilterDTO.getCreatedBy());
            if (emailFilterEntity != null) {
                return new EmailFilterDTO("Email filter already exist with this name");
            }

            emailFilterEntity = emailFilterMapper.emailFilterDtoToEntity(emailFilterDTO);
            emailFilterEntity = emailFilterDBService.saveEmailFilter(emailFilterEntity);

            if (emailFilterEntity != null) {
                return emailFilterMapper.entityToEmailFilterDto(emailFilterEntity);
            }
            return new EmailFilterDTO("Email filter not created");

        } catch (InvalidInputException e) {
            log.error("An exception thrown : ", e);
            return new EmailFilterDTO(e.getMessage());
        } catch (Exception e) {
            log.error("An Exception thrown : ", e);
            return new EmailFilterDTO("Email filter not created,Service not available");
        }
    }

    @Override
    public EmailFilterDTO modifyEmailFilter(EmailFilterDTO emailFilterDTO) {
        return null;
    }

    @Override
    public EmailFilterDTO deleteEmailFilter(Integer emailFilterId) {
        return null;
    }

    @Override
    public List<EmailFilterDTO> findAllEmailFilterByCreator(Integer createdById) {
        return List.of();
    }

    @Override
    public EmailFilterDTO findByEmailFilterById(Integer emailFilterId) {
        return null;
    }

    @Override
    public List<EmailCampaignRecipientDto> getAllEmailCampaignRecipientsByEmailFilterId(Integer emailFilterId) {
        return List.of();
    }
}
