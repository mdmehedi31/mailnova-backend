package com.mailnova.service.emailcampaign;

import com.mailnova.DTO.EmailCampaignDto;
import com.mailnova.exceptionmessage.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IEmailCampaign {

    public EmailCampaignDto createAndModifyEmailCampaign(EmailCampaignDto emailCampaignDto, MultipartFile file);
    public EmailCampaignDto getEmailCampaign(int id);
    public ApiResponse cancelEmailCampaign(int id);
    public ApiResponse deleteEmailCampaign(int id);
    public List<EmailCampaignDto> getAllEmailCampaigns();
}
