package com.mailnova.service.mapper;


import com.mailnova.DTO.EmailTemplateSubTypeDTO;
import com.mailnova.DTO.EmailTemplateTypeDTO;
import com.mailnova.core.entity.EmailTemplateSubTypeEntity;
import com.mailnova.core.entity.EmailTemplateTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailTemplateSubTypeMapper {

    EmailTemplateSubTypeEntity toEntity(EmailTemplateSubTypeDTO dto);

    EmailTemplateSubTypeDTO toDto(EmailTemplateSubTypeEntity entity);

    public List<EmailTemplateSubTypeDTO> toEmailTemplateList(List<EmailTemplateSubTypeEntity> entities);
    public EmailTemplateTypeEntity updateTypeEntity(EmailTemplateTypeDTO emailTemplateTypeDTO,
                                                    @MappingTarget EmailTemplateTypeEntity typeEntity);
}