package com.mailnova.service.mapper;


import com.mailnova.DTO.CompanyProfileDto;
import com.mailnova.core.entity.CompanyProfileEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyProfileMapper {
    CompanyProfileEntity dtoToEntity(CompanyProfileDto dto);
    CompanyProfileDto entityToDto(CompanyProfileEntity entity);
}
