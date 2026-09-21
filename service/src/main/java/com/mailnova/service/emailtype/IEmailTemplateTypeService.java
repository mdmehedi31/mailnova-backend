package com.mailnova.service.emailtype;


import com.mailnova.DTO.EmailTemplateSubTypeDTO;
import com.mailnova.DTO.EmailTemplateTypeDTO;
import com.mailnova.exceptionmessage.ApiResponse;

import java.util.List;

public interface IEmailTemplateTypeService {

    EmailTemplateTypeDTO createType(EmailTemplateTypeDTO dto);

    EmailTemplateTypeDTO updateType(EmailTemplateTypeDTO dto);

    EmailTemplateTypeDTO getTypeById(Integer id);

    List<EmailTemplateTypeDTO> getAllTypes();

    ApiResponse deleteType(Integer id);


    EmailTemplateSubTypeDTO createSubType(EmailTemplateSubTypeDTO dto);

    EmailTemplateSubTypeDTO updateSubType(EmailTemplateSubTypeDTO dto);

    EmailTemplateSubTypeDTO getSubTypeById(Integer id);

    List<EmailTemplateSubTypeDTO> getAllSubTypes();

    List<EmailTemplateSubTypeDTO> getSubTypesByTypeId(Integer typeId);

    ApiResponse deleteSubType(Integer id);
}