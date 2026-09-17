package com.mailnova.service.controller;


import com.mailnova.DTO.CompanyProfileDto;
import com.mailnova.DTO.GeneralApiResponse;
import com.mailnova.exceptionmessage.ApiResponse;
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
    public ResponseEntity<GeneralApiResponse> createCompanyProfile(@RequestBody CompanyProfileDto companyProfileDto) {
        GeneralApiResponse response =companyProfileService.createOrModifyCompanyProfile(companyProfileDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/modify")
    public ResponseEntity<GeneralApiResponse> updateCompanyProfile(@RequestBody CompanyProfileDto companyProfileDto) {
        GeneralApiResponse response =companyProfileService.createOrModifyCompanyProfile(companyProfileDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/user-company-profiles/{userId}")
    public ResponseEntity<List<CompanyProfileDto>> getUserCompanyProfiles(@PathVariable Integer userId) {
        List<CompanyProfileDto> companyProfileDtos = this.companyProfileService.getCompanyProfilesByUserId(userId);
        return new ResponseEntity<>(companyProfileDtos, HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<GeneralApiResponse> getCompanyProfileById(@PathVariable Integer id) {
        GeneralApiResponse companyProfileDto = this.companyProfileService.getCompanyProfileById(id);
        return new ResponseEntity<>(companyProfileDto, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteCompanyProfileById(@PathVariable Integer id) {
        ApiResponse response= this.companyProfileService.deleteCompanyProfile(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
