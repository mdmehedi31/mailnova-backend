package com.mailnova.service.mapper;

import com.mailnova.DTO.EmailFilterDTO;
import com.mailnova.core.entity.EmailFilterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailFilterMapper {

    @Mapping(target = "createdOn", expression = "java(LocalDateTime.now())")
    public EmailFilterEntity emailFilterDtoToEntity(EmailFilterDTO emailFilterDTO);
    public EmailFilterDTO entityToEmailFilterDto(EmailFilterEntity emailFilterEntity);
    public EmailFilterEntity updateEmailFilterDtoToEntity(EmailFilterDTO emailFilterDTO,
                                                          @MappingTarget EmailFilterEntity emailFilterEntity);

    public List<EmailFilterDTO> entityToEmailFilterDtoList(List<EmailFilterEntity> emailFilterEntities);
}
