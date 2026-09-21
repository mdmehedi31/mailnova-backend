package com.mailnova.service.mapper;


import com.mailnova.DTO.EmailTemplateTypeDTO;
import com.mailnova.core.entity.EmailTemplateTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailTemplateTypeMapper {

    public EmailTemplateTypeEntity dtoTO_entity(EmailTemplateTypeDTO dto);
    public EmailTemplateTypeDTO entityToDto(EmailTemplateTypeEntity entity);
    public List<EmailTemplateTypeDTO> emailTemplateEntitiesToList(Collection<EmailTemplateTypeEntity> entities);
    public EmailTemplateTypeEntity updateEntity( EmailTemplateTypeDTO  dto,
                                                 @MappingTarget EmailTemplateTypeEntity entity);

}
