

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
