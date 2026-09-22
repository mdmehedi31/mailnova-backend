

CREATE SCHEMA `mailnova`;


CREATE TABLE `mailnova`.`tb_user` (
                                      `id` INT NOT NULL AUTO_INCREMENT,
                                      `name` VARCHAR(500) NULL,
                                      `email` VARCHAR(250) NULL,
                                      `password` VARCHAR(250) NULL,
                                      `created_on` DATETIME NULL,
                                      `address` LONGTEXT NULL,
                                      PRIMARY KEY (`id`));


CREATE TABLE `mailnova`.`tb_comp_profile` (
                                              `id` INT NOT NULL AUTO_INCREMENT,
                                              `name` LONGTEXT NULL,
                                              `company_email` VARCHAR(400) NULL,
                                              `email_send_add` VARCHAR(400) NULL,
                                              `phone_no` VARCHAR(50) NULL,
                                              `address` LONGTEXT NULL,
                                              `contact_email` VARCHAR(400) NULL,
                                              PRIMARY KEY (`id`));

CREATE TABLE company_user (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              company_id INT NOT NULL,
                              user_id INT NOT NULL
);

CREATE TABLE email_campaign (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                name VARCHAR(4050) ,
                                created_on DATETIME ,
                                description VARCHAR(400),
                                created_by INT,
                                send_schedule_date DATETIME
);


CREATE TABLE email_template (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                type_id INT,
                                name VARCHAR(255),
                                email_subject VARCHAR(255),
                                email_body TEXT,
                                created_by INT,
                                created_on DATETIME,
                                is_public BOOLEAN DEFAULT FALSE,
                                is_ai_build BOOLEAN DEFAULT TRUE
);


CREATE TABLE email_campaign_template (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         email_campaign_id INT NOT NULL,
                                         email_template_id INT NOT NULL
);


CREATE TABLE email_campaign_recipient (
                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                          email_campaign_id INT NOT NULL,
                                          email VARCHAR(355) NOT NULL,
                                          email_added_at DATETIME DEFAULT CURRENT_TIMESTAMP,

                                          delivery_status VARCHAR(50) DEFAULT 'PENDING',
                                          delivery_failed_reason TEXT,

                                          opened_at DATETIME,
                                          read_count INT DEFAULT 0
);


ALTER TABLE `mailnova`.`tb_comp_profile`
    ADD COLUMN `created_at` DATETIME NULL AFTER `contact_email`;


ALTER TABLE `mailnova`.`tb_comp_profile`
    ADD COLUMN `is_deleted` TINYINT NULL DEFAULT 0 AFTER `created_at`;


ALTER TABLE `mailnova`.`tb_comp_profile`
    ADD COLUMN `created_by` INT NULL AFTER `is_deleted`;


ALTER TABLE `mailnova`.`tb_comp_profile`
    ADD COLUMN `website` LONGTEXT NULL AFTER `created_by`;

ALTER TABLE `mailnova`.`tb_comp_profile`
    ADD COLUMN `color_code` VARCHAR(50) NULL AFTER `website`

ALTER TABLE `mailnova`.`tb_comp_profile`
    ADD COLUMN `status` TINYINT NULL AFTER `color_code`;


ALTER TABLE `mailnova`.`tb_comp_profile`
    CHANGE COLUMN `status` `status` TINYINT NULL DEFAULT 1 ;


ALTER TABLE email_campaign
    CHANGE COLUMN send_schedule_date scheduled_at_utc TIMESTAMP NULL,

    ADD COLUMN timezone VARCHAR(100),
    ADD COLUMN status VARCHAR(30),

    ADD COLUMN started_on TIMESTAMP NULL,
    ADD COLUMN completed_on TIMESTAMP NULL,
    ADD COLUMN cancelled_on TIMESTAMP NULL,

    ADD COLUMN failure_reason TEXT;


ALTER TABLE email_campaign
    ADD COLUMN company_id boolean not null;

ALTER TABLE email_campaign
    ADD COLUMN is_deleted boolean not null;



CREATE TABLE tb_email_template_type (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(500) NOT NULL,
                                        description TEXT,
                                        is_active BOOLEAN NOT NULL DEFAULT TRUE,
                                        created_on DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);




CREATE TABLE tb_email_template_sub_type (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            name VARCHAR(500) NOT NULL,
                                            is_active BOOLEAN NOT NULL DEFAULT TRUE,
                                            created_on DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                            email_template_type_id BIGINT NOT NULL,

                                            CONSTRAINT fk_email_template_sub_type_type
                                                FOREIGN KEY (email_template_type_id)
                                                    REFERENCES tb_email_template_type(id)
);

ALTER TABLE `mailnova`.`email_template`
    CHANGE COLUMN `name` `name` VARCHAR(400) NULL DEFAULT NULL ,
    CHANGE COLUMN `email_subject` `email_subject` TEXT NULL DEFAULT NULL ;


ALTER TABLE `mailnova`.`email_template`
    ADD COLUMN `is_deleted` TINYINT NULL DEFAULT 1 AFTER `is_ai_build`;
