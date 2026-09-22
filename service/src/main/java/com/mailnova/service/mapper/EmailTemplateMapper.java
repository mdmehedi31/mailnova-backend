package com.mailnova.service.mapper;


import com.mailnova.DTO.EmailTemplateDto;
import com.mailnova.core.entity.EmailTemplateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailTemplateMapper {

    public EmailTemplateEntity emailTemplateDtoToEntity( EmailTemplateDto emailTemplateDto);
    public EmailTemplateDto entityToEmailTemplateDto( EmailTemplateEntity emailTemplateEntity);
    public List<EmailTemplateDto> entityToEmailTemplateDtoList(List<EmailTemplateEntity> emailTemplateEntities);
    public EmailTemplateEntity updateEmailTemplateDto( EmailTemplateDto emailTemplateDto,
                                                       @MappingTarget EmailTemplateEntity emailTemplateEntity);
}
