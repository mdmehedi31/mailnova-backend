package com.mailnova.service.controller;


import com.mailnova.DTO.EmailCampaignRecipientDto;
import com.mailnova.DTO.EmailFilterDTO;
import com.mailnova.exceptionmessage.ApiResponse;
import com.mailnova.service.emailfilter.IEmailFilterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email/filter")
public class EmailFilterController {

    private final IEmailFilterService emailFilterService;

    public EmailFilterController(IEmailFilterService emailFilterService) {
        this.emailFilterService = emailFilterService;
    }


    @PostMapping("/create")
    public ResponseEntity<EmailFilterDTO> createEmailFilter(@RequestBody EmailFilterDTO emailFilterDTO) {
        EmailFilterDTO saveResponse = this.emailFilterService.createEmailFilter(emailFilterDTO);
        return new ResponseEntity<>(saveResponse, HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<EmailFilterDTO> modifyEmailFilter(@RequestBody EmailFilterDTO emailFilterDTO) {
        EmailFilterDTO saveResponse = this.emailFilterService.modifyEmailFilter(emailFilterDTO);
        return new ResponseEntity<>(saveResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleted/{emailFilterId}")
    public ResponseEntity<ApiResponse> deleteEmailFilter(@PathVariable Integer emailFilterId) {
        ApiResponse apiResponse = this.emailFilterService.deleteEmailFilter(emailFilterId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/gets/{creatorId}")
    public ResponseEntity<List<EmailFilterDTO>> getAllEmailFilters(@PathVariable Integer creatorId) {
        List<EmailFilterDTO> emailFilterList = emailFilterService.getAllEmailFilterByCreator(creatorId);
        return new ResponseEntity<>(emailFilterList, HttpStatus.OK);
    }

    @GetMapping("/get/{emailFilterId}")
    public ResponseEntity<EmailFilterDTO> getEmailFilter(@PathVariable Integer emailFilterId) {
        EmailFilterDTO emailFilterDTO = this.emailFilterService.getEmailFilterById(emailFilterId);
        return new ResponseEntity<>(emailFilterDTO, HttpStatus.OK);
    }


    @GetMapping("/get-filter-email/{emailFilterId}")
    public ResponseEntity<List<EmailCampaignRecipientDto>> getEmailCampaignRecipients(@PathVariable Integer emailFilterId) {
        List<EmailCampaignRecipientDto> emailCampaignRecipientDtoList= this.emailFilterService.getAllEmailCampaignRecipientsByEmailFilterId(emailFilterId);
        return new ResponseEntity<>(emailCampaignRecipientDtoList, HttpStatus.OK);
    }
}
