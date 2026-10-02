package com.mailnova.service.controller;


import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.service.testService.FileUploadTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/test")
public class TestController {


    private FileUploadTestService uploadTestService;

    public TestController(FileUploadTestService uploadTestService) {
        this.uploadTestService = uploadTestService;
    }

    @PostMapping("/upload/{campaignId}")
    public ResponseEntity<String> testCsvUpload(@PathVariable("campaignId") Integer campaignId,
                                                @RequestParam("file") MultipartFile file) {
        EmailCampaignRecipientDto emailCampaignRecipientDto= new EmailCampaignRecipientDto();
        emailCampaignRecipientDto.setEmailCampaignId(campaignId);
        emailCampaignRecipientDto.setAttachment(file);
        String response= uploadTestService.uploadFile(emailCampaignRecipientDto);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
