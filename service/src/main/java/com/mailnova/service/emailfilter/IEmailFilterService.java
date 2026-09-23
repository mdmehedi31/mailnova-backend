package com.mailnova.service.emailfilter;

import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.DTO.EmailFilterDTO;
import com.mailnova.exceptionmessage.ApiResponse;

import java.util.List;

public interface IEmailFilterService {

    public EmailFilterDTO createEmailFilter(EmailFilterDTO emailFilterDTO);
    public EmailFilterDTO modifyEmailFilter(EmailFilterDTO emailFilterDTO);
    public ApiResponse deleteEmailFilter(Integer emailFilterId);
    public List<EmailFilterDTO> getAllEmailFilterByCreator(Integer createdById);
    public EmailFilterDTO getEmailFilterById(Integer emailFilterId);

    public List<EmailCampaignRecipientDto> getAllEmailCampaignRecipientsByEmailFilterId(Integer emailFilterId);
}
