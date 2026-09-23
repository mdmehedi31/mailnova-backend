package com.mailnova.core.dbservice;

import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.core.entity.EmailFilterEntity;
import com.mailnova.core.entity.EmailFilterRecipientEntity;
import com.mailnova.core.exceptionhandler.NotFoundException;
import com.mailnova.core.repository.EmailFilterRecipientRepository;
import com.mailnova.core.repository.EmailFilterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmailFilterDBService implements IEmailFilterDBService {

    private final EmailFilterRepository emailFilterRepository;
    private final EmailFilterRecipientRepository emailFilterRecipientRepository;

    public EmailFilterDBService(EmailFilterRepository emailFilterRepository,
                                EmailFilterRecipientRepository emailFilterRecipientRepository) {
        this.emailFilterRepository = emailFilterRepository;
        this.emailFilterRecipientRepository = emailFilterRecipientRepository;
    }

    @Override
    public EmailFilterEntity saveEmailFilter(EmailFilterEntity emailFilter) {
        try {
            return emailFilterRepository.save(emailFilter);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EmailFilterEntity getEmailFilter(Integer emailFilterId) {
        try {
            Optional<EmailFilterEntity> emailFilterEntity = emailFilterRepository.findById(emailFilterId);

            if (emailFilterEntity.isPresent()) {
                return emailFilterEntity.get();
            }
            return null;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EmailFilterEntity getEmailFilterByName(String emailFilterName, Integer creatorId) {
        try {
            return emailFilterRepository.findByNameAndCreatedBy(emailFilterName, creatorId);
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<EmailFilterEntity> getAllEmailFiltersByCreatorId(Integer creatorId) {
        try {
            List<EmailFilterEntity> emailFilterEntities = emailFilterRepository.findAllByCreatedBy(creatorId);
            if (emailFilterEntities !=null) {
                return emailFilterEntities;
            }
            return new ArrayList<EmailFilterEntity>();
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean deleteEmailFilter(EmailFilterEntity emailFilter) {
        try {
            emailFilterRepository.delete(emailFilter);
            return true;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<EmailCampaignRecipientDto> getAllEmailFilterRecipientsByEmailFilterId(Integer emailFilterId) {
        try {
            List<EmailCampaignRecipientDto> emailCampaignRecipientDtoList = emailFilterRecipientRepository.findAllByFilterEmailColId(emailFilterId);
            return emailCampaignRecipientDtoList;
        } catch (Exception e) {
            throw e;
        }
    }

    // Email filter recipient
    @Override
    public EmailFilterRecipientEntity saveEmailFilterRecipient(EmailFilterRecipientEntity emailFilterRecipient) {
        try {
            return emailFilterRecipientRepository.save(emailFilterRecipient);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean deleteEmailFilterRecipient(Integer emailFilterId) {
        try {
            emailFilterRecipientRepository.deleteAllByFilterEmailColId(emailFilterId);
            return true;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<EmailFilterRecipientEntity> saveEmailFilterRecipientList(List<EmailFilterRecipientEntity> emailFilterRecipientList) {
        try {
            return emailFilterRecipientRepository.saveAll(emailFilterRecipientList);
        } catch (Exception e) {
            throw e;
        }
    }
}
