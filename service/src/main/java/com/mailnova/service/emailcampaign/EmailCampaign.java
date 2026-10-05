package com.mailnova.service.emailcampaign;


import com.mailnova.DTO.EmailCampaignDto;
import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.core.dbservice.IEmailCampaignDBService;
import com.mailnova.core.entity.EmailCampaignEntity;
import com.mailnova.core.exceptionhandler.InvalidInputException;
import com.mailnova.enums.CampaignStatus;
import com.mailnova.enums.Response;
import com.mailnova.exceptionmessage.ApiResponse;
import com.mailnova.service.batch.EmailSentSchedulerRunner;
import com.mailnova.service.mapper.EmailCampaignMapper;
import com.mailnova.service.testService.EmailRecipientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EmailCampaign implements IEmailCampaign{

    private final IEmailCampaignDBService emailCampaignDBService;
    private final EmailCampaignMapper emailCampaignMapper;
    private final EmailRecipientService emailRecipientService;
    private EmailSentSchedulerRunner emailSentSchedulerRunner;


    private static final Logger log = LoggerFactory.getLogger(EmailCampaign.class);

    public EmailCampaign(IEmailCampaignDBService emailCampaignDBService,
                         EmailCampaignMapper emailCampaignMapper,
                         EmailRecipientService emailRecipientService,
                         EmailSentSchedulerRunner emailSentSchedulerRunner) {
        this.emailCampaignDBService = emailCampaignDBService;
        this.emailCampaignMapper = emailCampaignMapper;
        this.emailRecipientService = emailRecipientService;
        this.emailSentSchedulerRunner = emailSentSchedulerRunner;
    }

    @Override
    public EmailCampaignDto createAndModifyEmailCampaign(EmailCampaignDto emailCampaignDto, MultipartFile file) {
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

               EmailCampaignDto response = emailCampaignMapper.entityToDto(saveResponse);
                if(file !=null){
                    EmailCampaignRecipientDto recipientDto = new EmailCampaignRecipientDto();
                    recipientDto.setEmailCampaignId(saveResponse.getId());
                    recipientDto.setAttachment(file);

                    CompletableFuture.supplyAsync(()->{
                        log.info("Email uploading started");
                        return  emailRecipientService.uploadFile(recipientDto);
                    }).thenAccept(uploade->{

                        log.info("Uploaded email campaign attachment :: {}", uploade);
                        if(uploade) {
                            log.info("Start scheduling... ::: ::");
                            emailSentSchedulerRunner.setEmailSchedule(saveResponse.getId(),
                                    emailCampaignDto.getSendScheduleDate(), saveResponse.getTimezone());
                        }
                    });



                    /*if (recipientUploaded !=null){
                        response.setMessage(recipientUploaded.getMessage());
                    }*/
                }
                response.setMessage(Response.SUCCESS.name());
                return response;
            }
            return new EmailCampaignDto("Email campaign creation failed");
        }catch (InvalidInputException e) {
            log.error("An exception thrown : ",e);
            return new EmailCampaignDto("Email campaign creation failed");
        }
        catch (Exception e) {
            log.error("An exception thrown : ",e);
            return new EmailCampaignDto("Email campaign creation failed");
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
