package com.mailnova.service.controller;


import com.mailnova.DTO.CompanyProfileDto;
import com.mailnova.service.companyprofile.ICompanyProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user-company-profiles/{userId}")
    public ResponseEntity<List<CompanyProfileDto>> getUserCompanyProfiles(@PathVariable Integer userId) {
        List<CompanyProfileDto> companyProfileDtos = this.companyProfileService.getCompanyProfilesByUserId(userId);
        return new ResponseEntity<>(companyProfileDtos, HttpStatus.OK);
    }
}
