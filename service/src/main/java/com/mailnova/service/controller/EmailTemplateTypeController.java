package com.mailnova.service.controller;


import com.mailnova.DTO.EmailTemplateSubTypeDTO;
import com.mailnova.DTO.EmailTemplateTypeDTO;
import com.mailnova.exceptionmessage.ApiResponse;
import com.mailnova.service.emailtype.IEmailTemplateTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/email-template-types")
public class EmailTemplateTypeController {

    private final IEmailTemplateTypeService service;

    public EmailTemplateTypeController(IEmailTemplateTypeService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<EmailTemplateTypeDTO> createType(@RequestBody EmailTemplateTypeDTO dto) {
        EmailTemplateTypeDTO saveResponse = service.createType(dto);
        return new ResponseEntity<>(saveResponse, HttpStatus.CREATED);
    }

    @PutMapping("/modify")
    public ResponseEntity<EmailTemplateTypeDTO> updateType(@RequestBody EmailTemplateTypeDTO dto) {
        EmailTemplateTypeDTO saveResponse = service.updateType(dto);
        return new ResponseEntity<>(saveResponse, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmailTemplateTypeDTO> getType(
            @PathVariable Integer id) {
        EmailTemplateTypeDTO emailTemplateTypeDTO = service.getTypeById(id);
        return new ResponseEntity<>(emailTemplateTypeDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmailTemplateTypeDTO>> getAllTypes() {
        List<EmailTemplateTypeDTO> emailTemplateTypeDTOList = service.getAllTypes();
        return new ResponseEntity<>(emailTemplateTypeDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<ApiResponse> deleteType(@PathVariable Integer id) {
        ApiResponse response=service.deleteType(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // ================================
    // SUB TYPES
    // ================================

    @PostMapping("/sub-types")
    public ResponseEntity<EmailTemplateSubTypeDTO> createSubType(
            @RequestBody EmailTemplateSubTypeDTO dto) {
         EmailTemplateSubTypeDTO emailTemplateSubTypeDTO =service.createSubType(dto);
        return new ResponseEntity<>(emailTemplateSubTypeDTO, HttpStatus.CREATED);
    }

    @PutMapping("/sub-types/modifiy")
    public ResponseEntity<EmailTemplateSubTypeDTO> updateSubType(@RequestBody EmailTemplateSubTypeDTO dto) {
        EmailTemplateSubTypeDTO saveResponse = service.updateSubType(dto);
        return new ResponseEntity<>(saveResponse,HttpStatus.OK);
    }

    @GetMapping("/sub-types/{id}")
    public ResponseEntity<EmailTemplateSubTypeDTO> getSubType(
            @PathVariable Integer id) {
        EmailTemplateSubTypeDTO emailTemplateSubTypeDTO = service.getSubTypeById(id);
        return new ResponseEntity<>(emailTemplateSubTypeDTO, HttpStatus.OK);
    }

    @GetMapping("/sub-types")
    public ResponseEntity<List<EmailTemplateSubTypeDTO>> getAllSubTypes() {
        List<EmailTemplateSubTypeDTO> emailTemplateSubTypeDTOList = service.getAllSubTypes();
        return new ResponseEntity<>(emailTemplateSubTypeDTOList, HttpStatus.OK);
    }

    @GetMapping("/{typeId}/sub-types")
    public ResponseEntity<List<EmailTemplateSubTypeDTO>> getSubTypesByType(
            @PathVariable Integer typeId) {
        List<EmailTemplateSubTypeDTO> emailTemplateSubTypeDTO=service.getSubTypesByTypeId(typeId);
        return new ResponseEntity<>(emailTemplateSubTypeDTO, HttpStatus.OK);
    }

    @DeleteMapping("/sub-types/{id}")
    public ResponseEntity<ApiResponse> deleteSubType(@PathVariable Integer id) {
        ApiResponse response = this.service.deleteSubType(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}