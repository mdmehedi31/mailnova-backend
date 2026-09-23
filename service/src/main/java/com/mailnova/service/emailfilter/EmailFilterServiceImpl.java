package com.mailnova.service.emailfilter;


import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.DTO.EmailFilterDTO;
import com.mailnova.core.dbservice.IEmailFilterDBService;
import com.mailnova.core.entity.EmailFilterEntity;
import com.mailnova.core.entity.EmailFilterRecipientEntity;
import com.mailnova.core.exceptionhandler.InvalidInputException;
import com.mailnova.core.exceptionhandler.NotFoundException;
import com.mailnova.exceptionmessage.ApiResponse;
import com.mailnova.service.mapper.EmailFilterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Transactional(rollbackFor = {Exception.class, InvalidInputException.class})
    @Override
    public EmailFilterDTO createEmailFilter(EmailFilterDTO emailFilterDTO) {
        try {
            if (emailFilterDTO.getName() == null || emailFilterDTO.getName().isBlank()) {
                throw new InvalidInputException("Email Filter name cannot be empty");
            }
            if (emailFilterDTO.getCreatedBy() == null) {
                throw new InvalidInputException("Email Filter creator cannot be empty");
            }

            EmailFilterEntity emailFilterEntity = emailFilterDBService.getEmailFilterByName(emailFilterDTO.getName(),
                    emailFilterDTO.getCreatedBy());

            if (emailFilterEntity != null) {
                return new EmailFilterDTO("Email filter already exist with this name");
            }

            emailFilterEntity = emailFilterMapper.emailFilterDtoToEntity(emailFilterDTO);
            emailFilterEntity = emailFilterDBService.saveEmailFilter(emailFilterEntity);

            if (emailFilterEntity != null) {

                if (emailFilterDTO.getSelectedFilterEmailRecipientIds() != null && emailFilterDTO.getSelectedFilterEmailRecipientIds().size() > 0) {
                    saveEmailFilterRecipientList(emailFilterEntity.getId(), emailFilterDTO.getSelectedFilterEmailRecipientIds());
                }
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

    private Boolean saveEmailFilterRecipientList(Integer filterId, List<Integer> recipientIds) {

        try {
            List<EmailFilterRecipientEntity> emailFilterRecipientEntities = new ArrayList<>();

            for (Integer recipientId : recipientIds) {
                EmailFilterRecipientEntity emailFilterRecipientEntity = new EmailFilterRecipientEntity();
                emailFilterRecipientEntity.setFilterEmailColId(filterId);
                emailFilterRecipientEntity.setRecipientEmailId(recipientId);
                emailFilterRecipientEntities.add(emailFilterRecipientEntity);
            }

            emailFilterDBService.saveEmailFilterRecipientList(emailFilterRecipientEntities);
            return true;
        } catch (Exception e) {
            throw e;
        }

    }


    @Override
    public EmailFilterDTO modifyEmailFilter(EmailFilterDTO emailFilterDTO) {
        try {
            if (emailFilterDTO.getName() == null || emailFilterDTO.getName().isBlank()) {
                throw new InvalidInputException("Email Filter name cannot be empty");
            }
            if (emailFilterDTO.getCreatedBy() == null) {
                throw new InvalidInputException("Email Filter createdBy cannot be empty");
            }

            EmailFilterEntity emailFilterEntity = emailFilterDBService.getEmailFilterByName(emailFilterDTO.getName(),
                    emailFilterDTO.getCreatedBy());

            if (emailFilterEntity != null && !emailFilterDTO.getId().equals(emailFilterEntity.getId())) {
                return new EmailFilterDTO("Email filter already exist with this name");
            }

            emailFilterEntity = emailFilterDBService.getEmailFilter(emailFilterDTO.getId());

            if (emailFilterEntity == null) {
                throw new NotFoundException("Email filter not found");
            }

            emailFilterEntity = emailFilterMapper.updateEmailFilterDtoToEntity(emailFilterDTO, emailFilterEntity);
            emailFilterDBService.saveEmailFilter(emailFilterEntity);
            return emailFilterMapper.entityToEmailFilterDto(emailFilterEntity);

        } catch (NotFoundException e) {
            log.error("An exception thrown : ", e);
            return new EmailFilterDTO(e.getMessage());
        } catch (InvalidInputException e) {
            log.error("An exception thrown : ", e);
            return new EmailFilterDTO(e.getMessage());
        } catch (Exception e) {
            log.error("An Exception thrown : ", e);
            return new EmailFilterDTO("Email filter not modified,Service not available");
        }
    }


    @Transactional(rollbackFor = {Exception.class, RuntimeException.class, NotFoundException.class})
    @Override
    public ApiResponse deleteEmailFilter(Integer emailFilterId) {
        try {
            EmailFilterEntity emailFilterEntity = emailFilterDBService.getEmailFilter(emailFilterId);
            Boolean isDeleted = emailFilterDBService.deleteEmailFilterRecipient(emailFilterId);

            if (isDeleted) {
                boolean isFilterDeleted = emailFilterDBService.deleteEmailFilter(emailFilterEntity);
                if (isFilterDeleted) {
                    return new ApiResponse("Email filter deleted");
                }
            }
            return new ApiResponse("Email filter not deleted");
        } catch (NotFoundException e) {
            log.error("An exception thrown : ", e);
            return new ApiResponse(e.getMessage());
        } catch (InvalidInputException e) {
            log.error("An exception thrown : ", e);
            return new ApiResponse(e.getMessage());
        } catch (Exception e) {
            log.error("An Exception thrown : ", e);
            return new ApiResponse("Email filter not deleted,Service not available");
        }
    }

    @Override
    public List<EmailFilterDTO> getAllEmailFilterByCreator(Integer createdById) {
        try {
            List<EmailFilterEntity> emailFilterEntities = emailFilterDBService.getAllEmailFiltersByCreatorId(createdById);
            return emailFilterMapper.entityToEmailFilterDtoList(emailFilterEntities);
        } catch (Exception e) {
            log.error("An exception thrown : ", e);
            return new ArrayList<>();
        }
    }

    @Override
    public EmailFilterDTO getEmailFilterById(Integer emailFilterId) {
        try {

            EmailFilterEntity emailFilterEntity = emailFilterDBService.getEmailFilter(emailFilterId);
            if (emailFilterEntity == null) {
                return new EmailFilterDTO("Email filter not found");
            }
            return emailFilterMapper.entityToEmailFilterDto(emailFilterEntity);
        } catch (Exception e) {
            log.error("An exception thrown : ", e);
            return new EmailFilterDTO("Not found, Service not available");
        }
    }

    @Override
    public List<EmailCampaignRecipientDto> getAllEmailCampaignRecipientsByEmailFilterId(Integer emailFilterId) {
        try {

            return emailFilterDBService.getAllEmailFilterRecipientsByEmailFilterId(emailFilterId);
        } catch (Exception e) {
            log.error("An exception thrown : ", e);
            return new ArrayList<>();
        }
    }
}
