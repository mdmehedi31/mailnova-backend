package com.mailnova.service.mapper;


import com.mailnova.DTO.CompanyProfileDto;
import com.mailnova.core.entity.CompanyProfileEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyProfileMapper {

    CompanyProfileEntity dtoToEntity(CompanyProfileDto dto);
    CompanyProfileDto entityToDto(CompanyProfileEntity entity);
    List<CompanyProfileDto> entitesToDtos(List<CompanyProfileEntity> entities);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    void updateEntityFromDto(
            CompanyProfileDto dto,
            @MappingTarget CompanyProfileEntity entity
    );

}
