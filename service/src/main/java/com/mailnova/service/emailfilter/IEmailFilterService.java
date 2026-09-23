package com.mailnova.service.emailfilter;

import com.mailnova.DTO.EmailFilterDTO;

import java.util.List;

public interface IEmailFilterService {

    public EmailFilterDTO createEmailFilter(EmailFilterDTO emailFilterDTO);
    public EmailFilterDTO modifyEmailFilter(EmailFilterDTO emailFilterDTO);
    public EmailFilterDTO deleteEmailFilter(Integer emailFilterId);
    public List<EmailFilterDTO> findAllEmailFilterByCreator(Integer createdById);
    public EmailFilterDTO findByEmailFilterById(Integer emailFilterId);

}
