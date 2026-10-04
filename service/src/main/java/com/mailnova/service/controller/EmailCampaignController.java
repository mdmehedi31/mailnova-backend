package com.mailnova.service.controller;


import com.mailnova.DTO.EmailCampaignDto;
import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.exceptionmessage.ApiResponse;
import com.mailnova.service.emailcampaign.IEmailCampaign;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("/campaign")
public class EmailCampaignController {

    private final IEmailCampaign emailCampaignService;
    public EmailCampaignController(IEmailCampaign emailCampaignService) {
        this.emailCampaignService = emailCampaignService;
    }

    @PostMapping(value = "/create",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<EmailCampaignDto> createEmailCampaign(@RequestPart("campaign") EmailCampaignDto emailCampaignDto,
                                                                @RequestPart(value = "file", required = false) MultipartFile file) {
        EmailCampaignDto saveResponse = this.emailCampaignService.createAndModifyEmailCampaign(emailCampaignDto,file);
        return new ResponseEntity<>(saveResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmailCampaignDto> modifyEmailCampaign(@RequestBody EmailCampaignDto emailCampaignDto) {
        EmailCampaignDto updateResponse = this.emailCampaignService.createAndModifyEmailCampaign(emailCampaignDto, null);
        return new ResponseEntity<>(updateResponse, HttpStatus.OK);
    }

    @GetMapping("/get/{campaignId}")
    public ResponseEntity<EmailCampaignDto> getEmailCampaignById(@PathVariable Integer campaignId) {
        EmailCampaignDto emailCampaignDto =this.emailCampaignService.getEmailCampaign(campaignId);
        return new ResponseEntity<>(emailCampaignDto, HttpStatus.OK);
    }

    @PutMapping("/delete/{campaignId}")
    public ResponseEntity<ApiResponse> deleteEmailCampaign(@PathVariable Integer campaignId) {
        ApiResponse apiResponse = this.emailCampaignService.deleteEmailCampaign(campaignId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/cancel/{campaignId}")
    public ResponseEntity<ApiResponse> cancelEmailCampaign(@PathVariable Integer campaignId) {
        ApiResponse apiResponse = this.emailCampaignService.cancelEmailCampaign(campaignId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
