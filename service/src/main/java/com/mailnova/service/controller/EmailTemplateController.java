package com.mailnova.service.controller;

import com.mailnova.DTO.EmailTemplateDto;
import com.mailnova.exceptionmessage.ApiResponse;
import com.mailnova.service.emailtemplate.IEmailTemplateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/template")
public class EmailTemplateController {

    private final IEmailTemplateService emailTemplateService;

    public EmailTemplateController(IEmailTemplateService emailTemplateService) {
        this.emailTemplateService = emailTemplateService;
    }

    @PostMapping("/create")
    public ResponseEntity<EmailTemplateDto> createEmailTemplate(@RequestBody EmailTemplateDto emailTemplateDto) {
        EmailTemplateDto saveEmailTemplate = emailTemplateService.saveEmailTemplate(emailTemplateDto);
        return new ResponseEntity<>(saveEmailTemplate, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmailTemplateDto> updateEmailTemplate(@RequestBody EmailTemplateDto emailTemplateDto) {
        EmailTemplateDto saveEmailTemplate = emailTemplateService.updateEmailTemplate(emailTemplateDto);
        return new ResponseEntity<>(saveEmailTemplate, HttpStatus.OK);
    }

    @PutMapping("/deleted/{templateId}")
    public ResponseEntity<ApiResponse> deleteEmailTemplate(@PathVariable Integer templateId) {
        ApiResponse apiResponse = emailTemplateService.deleteEmailTemplate(templateId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/get/{templateId}")
    public ResponseEntity<EmailTemplateDto> getEmailTemplate(@PathVariable Integer templateId) {
        EmailTemplateDto emailTemplateDto = emailTemplateService.getEmailTemplate(templateId);
        return new ResponseEntity<>(emailTemplateDto, HttpStatus.OK);
    }

    @GetMapping("/gets/{creatorId}")
    public ResponseEntity<List<EmailTemplateDto>> getAllEmailTemplatesByCreatorId(@PathVariable Integer creatorId) {
        List<EmailTemplateDto> emailTemplateDtoList = emailTemplateService.getAllEmailTemplate(creatorId);
        return new ResponseEntity<>(emailTemplateDtoList, HttpStatus.OK);
    }
}
