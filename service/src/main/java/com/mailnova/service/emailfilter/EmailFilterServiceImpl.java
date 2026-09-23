package com.mailnova.service.emailfilter;


import com.mailnova.DTO.EmailFilterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailFilterServiceImpl  implements IEmailFilterService {
    @Override
    public EmailFilterDTO createEmailFilter(EmailFilterDTO emailFilterDTO) {
        return null;
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
}
