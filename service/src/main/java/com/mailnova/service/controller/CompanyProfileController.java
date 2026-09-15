package com.mailnova.service.controller;


import com.mailnova.DTO.CompanyProfileDto;
import com.mailnova.service.companyprofile.ICompanyProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company-profile")
public class CompanyProfileController {

    private final ICompanyProfileService companyProfileService;

    public CompanyProfileController(ICompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }


    @PostMapping("/create")
    public ResponseEntity<CompanyProfileDto> createCompanyProfile(@RequestBody CompanyProfileDto companyProfileDto) {
        CompanyProfileDto response =companyProfileService.createOrModifyCompanyProfile(companyProfileDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
