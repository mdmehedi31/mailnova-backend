package com.mailnova.DTO;


import com.mailnova.exceptionmessage.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;

public class EmailFilterDTO extends ApiResponse {

    private Integer id;

    private String name;

    private LocalDateTime createdOn;

    private Integer createdBy;

    private String description;

    private List<Integer> selectedFilterEmailRecipientIds;

    public EmailFilterDTO() {
    }

    public EmailFilterDTO(String message) {
        super(message);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getSelectedFilterEmailRecipientIds() {
        return selectedFilterEmailRecipientIds;
    }

    public void setSelectedFilterEmailRecipientIds(List<Integer> selectedFilterEmailRecipientIds) {
        this.selectedFilterEmailRecipientIds = selectedFilterEmailRecipientIds;
    }
}
