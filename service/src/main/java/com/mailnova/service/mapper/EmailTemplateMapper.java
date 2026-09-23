package com.mailnova.service.mapper;


import com.mailnova.DTO.EmailTemplateDto;
import com.mailnova.core.entity.EmailTemplateEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailTemplateMapper {

    public EmailTemplateEntity emailTemplateDtoToEntity( EmailTemplateDto emailTemplateDto);
    public EmailTemplateDto entityToEmailTemplateDto( EmailTemplateEntity emailTemplateEntity);
    public List<EmailTemplateDto> entityToEmailTemplateDtoList(List<EmailTemplateEntity> emailTemplateEntities);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public EmailTemplateEntity updateEmailTemplateDto( EmailTemplateDto emailTemplateDto,
                                                       @MappingTarget EmailTemplateEntity emailTemplateEntity);
}
