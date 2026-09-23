package com.mailnova.service.mapper;


import com.mailnova.DTO.EmailTemplateSubTypeDTO;
import com.mailnova.DTO.EmailTemplateTypeDTO;
import com.mailnova.core.entity.EmailTemplateSubTypeEntity;
import com.mailnova.core.entity.EmailTemplateTypeEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailTemplateSubTypeMapper {

    EmailTemplateSubTypeEntity toEntity(EmailTemplateSubTypeDTO dto);

    EmailTemplateSubTypeDTO toDto(EmailTemplateSubTypeEntity entity);

    public List<EmailTemplateSubTypeDTO> toEmailTemplateList(List<EmailTemplateSubTypeEntity> entities);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public EmailTemplateTypeEntity updateTypeEntity(EmailTemplateTypeDTO emailTemplateTypeDTO,
                                                    @MappingTarget EmailTemplateTypeEntity typeEntity);
}