package com.mailnova.service.mapper;

import com.mailnova.DTO.EmailFilterDTO;
import com.mailnova.core.entity.EmailFilterEntity;
import org.mapstruct.*;
import java.time.LocalDateTime;

import java.util.List;

@Mapper(componentModel = "spring",
imports = {java.time.LocalDateTime.class})
public interface EmailFilterMapper {

    @Mapping(target = "createdOn", expression = "java(LocalDateTime.now())")
    public EmailFilterEntity emailFilterDtoToEntity(EmailFilterDTO emailFilterDTO);
    public EmailFilterDTO entityToEmailFilterDto(EmailFilterEntity emailFilterEntity);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public EmailFilterEntity updateEmailFilterDtoToEntity(EmailFilterDTO emailFilterDTO,
                                                          @MappingTarget EmailFilterEntity emailFilterEntity);

    public List<EmailFilterDTO> entityToEmailFilterDtoList(List<EmailFilterEntity> emailFilterEntities);
}
