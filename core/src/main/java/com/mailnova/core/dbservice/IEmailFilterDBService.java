package com.mailnova.core.dbservice;

import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.core.entity.EmailCampaignRecipientEntity;
import com.mailnova.core.entity.EmailFilterEntity;
import com.mailnova.core.entity.EmailFilterRecipientEntity;

import java.util.List;

public interface IEmailFilterDBService {

    // Email filter add
    public EmailFilterEntity saveEmailFilter(EmailFilterEntity emailFilter);
    public EmailFilterEntity getEmailFilter(Integer emailFilterId);
    public EmailFilterEntity getEmailFilterByName(String emailFilterName, Integer creatorId);
    public List<EmailFilterEntity> getAllEmailFiltersByCreatorId(Integer creatorId);
    public Boolean deleteEmailFilter(EmailFilterEntity emailFilter);
    public List<EmailCampaignRecipientDto> getAllEmailFilterRecipientsByEmailFilterId(Integer emailFilterId);

    // Email filter recipient
    public EmailFilterRecipientEntity saveEmailFilterRecipient(EmailFilterRecipientEntity emailFilterRecipient);
    public Boolean deleteEmailFilterRecipient(Integer emailFilterId);
    public List<EmailFilterRecipientEntity> saveEmailFilterRecipientList(List<EmailFilterRecipientEntity> emailFilterRecipientList);

}
