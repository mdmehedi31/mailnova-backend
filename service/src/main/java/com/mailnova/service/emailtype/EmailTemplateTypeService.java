package com.mailnova.service.emailtype;


import com.mailnova.DTO.EmailTemplateSubTypeDTO;
import com.mailnova.DTO.EmailTemplateTypeDTO;
import com.mailnova.core.entity.EmailTemplateSubTypeEntity;
import com.mailnova.core.entity.EmailTemplateTypeEntity;
import com.mailnova.core.exceptionhandler.InvalidInputException;
import com.mailnova.core.exceptionhandler.NotFoundException;
import com.mailnova.core.repository.EmailTemplateSubTypeRepository;
import com.mailnova.core.repository.EmailTemplateTypeRepository;
import com.mailnova.exceptionmessage.ApiResponse;
import com.mailnova.service.mapper.EmailTemplateSubTypeMapper;
import com.mailnova.service.mapper.EmailTemplateTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmailTemplateTypeService implements IEmailTemplateTypeService {

    private final EmailTemplateTypeRepository emailTemplateTypeRepository;
    private final EmailTemplateSubTypeRepository emailTemplateSubTypeRepository;

    private final EmailTemplateTypeMapper emailTemplateTypeMapper;
    private final EmailTemplateSubTypeMapper emailTemplateSubTypeMapper;

    private static final Logger log = LoggerFactory.getLogger(EmailTemplateTypeService.class);

    public EmailTemplateTypeService(EmailTemplateTypeRepository emailTemplateTypeRepository, EmailTemplateSubTypeRepository emailTemplateSubTypeRepository,
                                    EmailTemplateTypeMapper emailTemplateTypeMapper, EmailTemplateSubTypeMapper emailTemplateSubTypeMapper) {
        this.emailTemplateTypeRepository = emailTemplateTypeRepository;
        this.emailTemplateSubTypeRepository = emailTemplateSubTypeRepository;
        this.emailTemplateTypeMapper = emailTemplateTypeMapper;
        this.emailTemplateSubTypeMapper = emailTemplateSubTypeMapper;
    }

    @Override
    public EmailTemplateTypeDTO createType(EmailTemplateTypeDTO dto) {
        try{

            if (dto.getName() == null || dto.getName().isBlank()) {
                throw new InvalidParameterException("Name cannot be empty");
            }

            EmailTemplateTypeEntity isExist = emailTemplateTypeRepository.findByName(dto.getName());
            if (isExist != null ) {
                return new EmailTemplateTypeDTO("Email Template Type already exists");
            }

            EmailTemplateTypeEntity entity =
                    emailTemplateTypeMapper.dtoTO_entity(dto);

            entity.setCreatedOn(LocalDateTime.now());

            EmailTemplateTypeEntity saved =
                    emailTemplateTypeRepository.save(entity);

            return emailTemplateTypeMapper.entityToDto(saved);

        }catch (Exception e){
            log.error("An exception thrown : ",e);
            return null;
        }
    }


    @Override
    public EmailTemplateTypeDTO updateType(EmailTemplateTypeDTO dto) {

        try{

            Optional<EmailTemplateTypeEntity> entityOpt =
                    emailTemplateTypeRepository.findById(dto.getId());

            if (!entityOpt.isPresent()) {
                throw new NotFoundException("Email template not found");
            }
            EmailTemplateTypeEntity entity = entityOpt.get();

            EmailTemplateTypeEntity isExist = emailTemplateTypeRepository.findByName(dto.getName());
            if (isExist != null && !isExist.getId().equals(dto.getId())) {
                return new EmailTemplateTypeDTO("Email Template Type already exists");
            }

            entity = emailTemplateTypeMapper.updateEntity(dto, entity);

            EmailTemplateTypeEntity updated =
                    emailTemplateTypeRepository.save(entity);

            return emailTemplateTypeMapper.entityToDto(updated);
        }catch (NotFoundException e){
            log.error("An exception thrown : ",e);
            return null;
        }
        catch (Exception e){
            log.error("An exception thrown : ",e);
            return null;
        }

    }


    @Override
    public EmailTemplateTypeDTO getTypeById(Integer id) {

        try{
            Optional<EmailTemplateTypeEntity> entityOpt =
                    emailTemplateTypeRepository.findByIdAndIsActiveIsNullOrIsActive(id);

            if (!entityOpt.isPresent()) {
                throw new NotFoundException("Email template not found");
            }

            EmailTemplateTypeEntity entity = entityOpt.get();

            return emailTemplateTypeMapper.entityToDto(entity);
        }catch (NotFoundException e) {
            log.error("An exception thrown : ", e);
            return new EmailTemplateTypeDTO("Email template not found");
        }
        catch (Exception e){
            log.error("An exception thrown : ",e);
            return null;
        }

    }


    @Override
    public List<EmailTemplateTypeDTO> getAllTypes() {
        try{

            List<EmailTemplateTypeEntity> emailTemplateTypeEntities= this.emailTemplateTypeRepository.findAllByIsActiveIsNullOrIsActive(true);
            return emailTemplateTypeMapper.emailTemplateEntitiesToList(emailTemplateTypeEntities);

        }catch (Exception e){
            log.error("An exception thrown : ",e);
            return new ArrayList<>();
        }
    }


    @Override
    public ApiResponse deleteType(Integer id) {
        try{
          Optional<EmailTemplateTypeEntity> entityOpt = emailTemplateTypeRepository.findById(id);

          if(!entityOpt.isPresent()) {
              return new ApiResponse("Email template not found");
          }
          emailTemplateTypeRepository.deleteById(entityOpt.get().getId());
          return new ApiResponse("Email template deleted");
        }catch (Exception e){
            log.error("An exception thrown : ",e);

            return new ApiResponse("Email template deleted successfully");
        }
    }


    // ================================
    // SUB TYPE
    // ================================


    @Override
    public EmailTemplateSubTypeDTO createSubType(EmailTemplateSubTypeDTO dto) {

        try{

            if(dto.getName() == null || dto.getName().isBlank()) {
                throw new InvalidInputException("Name cannot be empty");
            }

            if (dto.getEmailTemplateTypeId()==null){
                throw new InvalidInputException("Parent Email template type cannot be empty");
            }
            Optional<EmailTemplateTypeEntity> type =
                    emailTemplateTypeRepository.findById(
                                    dto.getEmailTemplateTypeId());

            if (!type.isPresent()) {
                throw new NotFoundException("Email template type not found");
            }

            EmailTemplateSubTypeEntity emailTemplateSubTypeEntity = this.emailTemplateSubTypeRepository.
                    findByEmailTemplateTypeIdAndName(dto.getEmailTemplateTypeId(), dto.getName());

            if (emailTemplateSubTypeEntity != null) {
                return new EmailTemplateSubTypeDTO("Email sub-template type already exists");
            }
            EmailTemplateSubTypeEntity entity =
                    emailTemplateSubTypeMapper.toEntity(dto);

            entity.setEmailTemplateTypeId(type.get().getId());
            entity.setCreatedOn(LocalDateTime.now());

            EmailTemplateSubTypeEntity saved =
                    emailTemplateSubTypeRepository.save(entity);

            return emailTemplateSubTypeMapper.toDto(saved);

        }catch (InvalidInputException e){
            log.error("An exception thrown : ",e);
            return new EmailTemplateSubTypeDTO(e.getMessage());
        }
        catch (NotFoundException e){
            log.error("An exception thrown : ",e);
            return new EmailTemplateSubTypeDTO(e.getMessage());
        }
        catch (Exception e){
            log.error("An exception thrown : ",e);
            return new EmailTemplateSubTypeDTO();
        }
    }


    @Override
    public EmailTemplateSubTypeDTO updateSubType(EmailTemplateSubTypeDTO dto) {

        try{

            Optional<EmailTemplateSubTypeEntity> entityOpt =
                    emailTemplateSubTypeRepository.findById(dto.getId());

            if (!entityOpt.isPresent()) {
                throw new NotFoundException("Email template subtype not found");
            }

            Optional<EmailTemplateTypeEntity> type =
                    emailTemplateTypeRepository.findById(
                                    dto.getEmailTemplateTypeId());


            if (!type.isPresent()) {
                throw new NotFoundException("Email template type not found");
            }

            EmailTemplateSubTypeEntity emailTemplateSubTypeEntity= emailTemplateSubTypeRepository.findByEmailTemplateTypeIdAndName(dto.getEmailTemplateTypeId(), dto.getName());

            if(emailTemplateSubTypeEntity != null && !emailTemplateSubTypeEntity.getId().equals(dto.getId())) {
                return new EmailTemplateSubTypeDTO("Email sub-template type already exists");
            }

            EmailTemplateSubTypeEntity entity= entityOpt.get();
            entity.setName(dto.getName());
            entity.setIsActive(dto.getIsActive());
            entity.setEmailTemplateTypeId(type.get().getId());

            EmailTemplateSubTypeEntity updated =
                    emailTemplateSubTypeRepository.save(entity);

            return emailTemplateSubTypeMapper.toDto(updated);

        }catch (NotFoundException e){
            log.error("An exception thrown : ",e);
            return new EmailTemplateSubTypeDTO(e.getMessage());
        }
        catch (Exception e){
            log.error("An exception thrown : ",e);
            return null;
        }
    }


    @Override
    public EmailTemplateSubTypeDTO getSubTypeById(Integer id) {
        try{

            Optional<EmailTemplateSubTypeEntity> entityOpt =
                    emailTemplateSubTypeRepository.findByIdAndIsActive(id);

            if (!entityOpt.isPresent()) {
                throw new NotFoundException("Email template subtype not found");
            }
            EmailTemplateSubTypeEntity entity = entityOpt.get();
            return emailTemplateSubTypeMapper.toDto(entity);

        }catch (NotFoundException e){
            log.error("An exception thrown : ",e);
            return new EmailTemplateSubTypeDTO(e.getMessage());
        }
        catch (Exception e){
            log.error("An exception thrown : ",e);
            return null;
        }
    }


    @Override
    public List<EmailTemplateSubTypeDTO> getAllSubTypes() {

        try{
            List<EmailTemplateSubTypeEntity> emailTemplateSubTypeEntities = emailTemplateSubTypeRepository.findAllAndIsActive();

            return emailTemplateSubTypeMapper.toEmailTemplateList(emailTemplateSubTypeEntities);

        }catch (Exception e){
            log.error("An exception thrown : ",e);
            return new ArrayList<>();
        }
    }


    @Override
    public List<EmailTemplateSubTypeDTO> getSubTypesByTypeId(
            Integer typeId) {

        try {
            List<EmailTemplateSubTypeEntity> emailTemplateSubTypeEntities = emailTemplateSubTypeRepository
                    .findByEmailTemplateTypeId(typeId);

            return emailTemplateSubTypeMapper.toEmailTemplateList(emailTemplateSubTypeEntities);
        } catch (Exception e) {
            log.error("An exception thrown : ", e);
            return new ArrayList<>();
        }
    }


    @Override
    public ApiResponse deleteSubType(Integer id) {

        try{

            Optional<EmailTemplateSubTypeEntity> entityOpt =
                    emailTemplateSubTypeRepository.findById(id);

            if (!entityOpt.isPresent()) {
                throw new NotFoundException("Email template subtype not found");
            }

            emailTemplateSubTypeRepository.delete(entityOpt.get());
            return new ApiResponse("Email template subtype deleted");
        }catch (NotFoundException e){
            log.error("An exception thrown : ",e);
            return new ApiResponse("Email template subtype not found with this id");
        }catch (Exception e){
            log.error("An exception thrown : ",e);
            return new ApiResponse("Service not available");
        }

    }
}