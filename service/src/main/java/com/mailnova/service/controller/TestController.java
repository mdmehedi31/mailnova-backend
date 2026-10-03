package com.mailnova.service.controller;


import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.exceptionmessage.ApiResponse;
import com.mailnova.service.testService.EmailRecipientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/test")
public class TestController {


    private EmailRecipientService uploadTestService;

    public TestController(EmailRecipientService uploadTestService) {
        this.uploadTestService = uploadTestService;
    }

    @PostMapping("/upload/{campaignId}")
    public ResponseEntity<ApiResponse> testCsvUpload(@PathVariable("campaignId") Integer campaignId,
                                                     @RequestParam("file") MultipartFile file) {
        EmailCampaignRecipientDto emailCampaignRecipientDto= new EmailCampaignRecipientDto();
        emailCampaignRecipientDto.setEmailCampaignId(campaignId);
        emailCampaignRecipientDto.setAttachment(file);
        ApiResponse response= uploadTestService.uploadFile(emailCampaignRecipientDto);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
