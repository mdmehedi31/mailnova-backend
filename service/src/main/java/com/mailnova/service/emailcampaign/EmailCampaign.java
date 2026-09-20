package com.mailnova.service.emailcampaign;


import com.mailnova.DTO.EmailCampaignDto;
import com.mailnova.core.dbservice.IEmailCampaignDBService;
import com.mailnova.core.entity.EmailCampaignEntity;
import com.mailnova.core.exceptionhandler.InvalidInputException;
import com.mailnova.enums.CampaignStatus;
import com.mailnova.exceptionmessage.ApiResponse;
import com.mailnova.service.mapper.EmailCampaignMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailCampaign implements IEmailCampaign{

    private final IEmailCampaignDBService emailCampaignDBService;
    private final EmailCampaignMapper emailCampaignMapper;

    private static final Logger log = LoggerFactory.getLogger(EmailCampaign.class);

    public EmailCampaign(IEmailCampaignDBService emailCampaignDBService, EmailCampaignMapper emailCampaignMapper) {
        this.emailCampaignDBService = emailCampaignDBService;
        this.emailCampaignMapper = emailCampaignMapper;
    }

    @Override
    public EmailCampaignDto createAndModifyEmailCampaign(EmailCampaignDto emailCampaignDto) {
        try {

            if(emailCampaignDto==null){
                throw new InvalidInputException("Email campaign cannot be null");
            }

            if(emailCampaignDto.getName() == null || emailCampaignDto.getName().isBlank()){
                throw new InvalidInputException("Email campaign name cannot be empty");
            }
            if (emailCampaignDto.getCompanyId() == null){
                throw new InvalidInputException("Email campaign company id cannot be empty");
            }


            EmailCampaignEntity isExist = this.emailCampaignDBService.findByNameAndCreatedBy(emailCampaignDto.getName(), emailCampaignDto.getCreatedBy());

            if (isExist != null &&
                    (emailCampaignDto.getId()==null ||
                            (emailCampaignDto.getId()!= null && !emailCampaignDto.getId().equals(isExist.getId())))){
                return new EmailCampaignDto("You already created email campaign with this name");
            }


            EmailCampaignEntity emailCampaignEntity =null;
            if(emailCampaignDto.getId() !=null){
                emailCampaignEntity= this.emailCampaignDBService.findById(emailCampaignDto.getId());
                emailCampaignEntity= emailCampaignMapper.updateEmailCampaign(emailCampaignDto,emailCampaignEntity);
            }else {
                emailCampaignEntity = emailCampaignMapper.dtoToEntity(emailCampaignDto);
                emailCampaignEntity.setCreatedOn(LocalDateTime.now());
                emailCampaignEntity.setStatus(CampaignStatus.SEND.name());
            }

            if(emailCampaignEntity==null){
                return null;
            }

            EmailCampaignEntity saveResponse= this.emailCampaignDBService.save(emailCampaignEntity);
            if(saveResponse!=null){
                return emailCampaignMapper.entityToDto(saveResponse);
            }
            return null;
        }catch (InvalidInputException e) {
            log.error("An exception thrown : ",e);
            return null;
        }
        catch (Exception e) {
            log.error("An exception thrown : ",e);
            return null;
        }
    }

    @Override
    public EmailCampaignDto getEmailCampaign(int id) {
        try{
            EmailCampaignEntity emailCampaignEntity= this.emailCampaignDBService.findById(id);

            if(emailCampaignEntity==null){
                return new EmailCampaignDto("Campaign not found");
            }

            return emailCampaignMapper.entityToDto(emailCampaignEntity);
        }catch (Exception e) {
            log.error("An exception thrown : ",e);
            return null;
        }
    }

    @Override
    public ApiResponse cancelEmailCampaign(int id) {
        ApiResponse apiResponse = new ApiResponse();
        try {

            EmailCampaignEntity emailCampaignEntity = this.emailCampaignDBService.findById(id);
            if (emailCampaignEntity == null) {
                apiResponse.setMessage("Campaign not found");
                return apiResponse;
            }

            log.info("Does email campaign is deleted :: {}", emailCampaignEntity==null);

            emailCampaignEntity.setCancelledOn(Instant.now());
            this.emailCampaignDBService.save(emailCampaignEntity);
            apiResponse.setMessage("Email campaign has been cancelled");
            return apiResponse;
        } catch (Exception e) {
            log.error("An exception thrown : ", e);
            return new ApiResponse("Email campaign has not been cancelled, Service is not available now, we will back soon");
        }
    }

    @Override
    public ApiResponse deleteEmailCampaign(int id) {
        try {
            EmailCampaignEntity emailCampaignEntity= this.emailCampaignDBService.findById(id);
            if(emailCampaignEntity!=null){
                log.info("Email id and deleted value is : {}, {}", emailCampaignEntity.getId(),
                        emailCampaignEntity.getDeleted());

                emailCampaignEntity.setDeleted(true);
                this.emailCampaignDBService.save(emailCampaignEntity);
                return new ApiResponse("Email campaign has been deleted");
            }
            return new ApiResponse("Email campaign has not been deleted, Cause its not found");
        }catch (Exception e) {
            log.error("An exception thrown : ",e);
            return  new ApiResponse("Email campaign delete failed");
        }
    }

    @Override
    public List<EmailCampaignDto> getAllEmailCampaigns() {
        return List.of();
    }
}
