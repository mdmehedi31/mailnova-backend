package com.mailnova.core.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_email_filter_recipient")
public class EmailFilterRecipientEntity extends AbstractIdEntity{

    @Column(name = "filter_email_col_id")
    private Integer filterEmailColId;

    @Column(name = "recipient_email_id")
    private Integer recipientEmailId;

    public Integer getFilterEmailColId() {
        return filterEmailColId;
    }

    public void setFilterEmailColId(Integer filterEmailColId) {
        this.filterEmailColId = filterEmailColId;
    }

    public Integer getRecipientEmailId() {
        return recipientEmailId;
    }

    public void setRecipientEmailId(Integer recipientEmailId) {
        this.recipientEmailId = recipientEmailId;
    }
}
