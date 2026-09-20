package com.mailnova.service.mapper;


import com.mailnova.DTO.EmailCampaignDto;
import com.mailnova.core.entity.EmailCampaignEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface EmailCampaignMapper {

    public EmailCampaignEntity dtoToEntity(EmailCampaignDto dto);
    public EmailCampaignDto entityToDto(EmailCampaignEntity entity);

    @BeanMapping (
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public EmailCampaignEntity updateEmailCampaign(EmailCampaignDto emailCampaignDto,
                                                   @MappingTarget EmailCampaignEntity emailCampaignEntity);
}
