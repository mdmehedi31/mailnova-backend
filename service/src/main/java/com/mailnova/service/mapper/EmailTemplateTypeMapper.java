package com.mailnova.service.mapper;


import com.mailnova.DTO.EmailTemplateTypeDTO;
import com.mailnova.core.entity.EmailTemplateTypeEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailTemplateTypeMapper {

    public EmailTemplateTypeEntity dtoTO_entity(EmailTemplateTypeDTO dto);
    public EmailTemplateTypeDTO entityToDto(EmailTemplateTypeEntity entity);
    public List<EmailTemplateTypeDTO> emailTemplateEntitiesToList(Collection<EmailTemplateTypeEntity> entities);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public EmailTemplateTypeEntity updateEntity( EmailTemplateTypeDTO  dto,
                                                 @MappingTarget EmailTemplateTypeEntity entity);

}
