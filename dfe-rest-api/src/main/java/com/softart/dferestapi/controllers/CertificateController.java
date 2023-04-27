package com.softart.dferestapi.controllers;

import com.softart.dferestapi.constants.CertificateControllerConstants;
import com.softart.dferestapi.constants.HttpStatusCode;
import com.softart.dferestapi.constants.RestControllerConstants;
import com.softart.dferestapi.models.certificate.CertificateDTO;
import com.softart.dferestapi.models.certificate.request.CertificateCreate;
import com.softart.dferestapi.models.response.error.CommonError;
import com.softart.dferestapi.models.response.error.ValidationError;
import com.softart.dferestapi.models.response.list.ListResponse;
import com.softart.dferestapi.services.certificate.CertificateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Collectors;

@RestController
@RequestMapping(CertificateControllerConstants.BASE_PATH)
@Getter
public final class CertificateController {

    private final CertificateService certificateService;

    @Autowired
    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @Operation(summary = CertificateControllerConstants.OPENAPI_LIST_SUMMARY, tags = CertificateControllerConstants.OPEN_API_TAG, description = CertificateControllerConstants.OPENAPI_LIST_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNAUTHORIZED, description = HttpStatusCode.UNAUTHORIZED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ListResponse.CertificateListResponse.class))})
    })
    @GetMapping(value = RestControllerConstants.LIST_PATH)
    public ResponseEntity<ListResponse<CertificateDTO>> findAll() {
        ListResponse<CertificateDTO> response = new ListResponse<>(getCertificateService().findAll().stream().map(CertificateDTO::new).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @SneakyThrows
    @Operation(summary = CertificateControllerConstants.OPENAPI_CREATE_SUMMARY, tags = CertificateControllerConstants.OPEN_API_TAG, description = CertificateControllerConstants.OPENAPI_CREATE_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNAUTHORIZED, description = HttpStatusCode.UNAUTHORIZED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CREATED, description = HttpStatusCode.CREATED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CertificateDTO.class))})
    })
    @PostMapping(value = RestControllerConstants.CREATE_PATH, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CertificateDTO> create(@RequestPart("file") MultipartFile file, @RequestPart("password") String password) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new CertificateDTO(getCertificateService().create(CertificateCreate.builder().bytes(file.getBytes()).password(password).build())));
    }

    @Operation(summary = CertificateControllerConstants.OPENAPI_DETAIL_SUMMARY, tags = CertificateControllerConstants.OPEN_API_TAG, description = CertificateControllerConstants.OPENAPI_DETAIL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNAUTHORIZED, description = HttpStatusCode.UNAUTHORIZED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.NOT_FOUND, description = HttpStatusCode.NOT_FOUND_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CertificateDTO.class))})
    })
    @GetMapping(value = RestControllerConstants.DETAIL_PATH)
    public ResponseEntity<CertificateDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new CertificateDTO(getCertificateService().findById(id)));
    }

    @Operation(summary = CertificateControllerConstants.OPENAPI_DELETE_SUMMARY, tags = CertificateControllerConstants.OPEN_API_TAG, description = CertificateControllerConstants.OPENAPI_DELETE_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.NOT_FOUND, description = HttpStatusCode.NOT_FOUND_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNAUTHORIZED, description = HttpStatusCode.UNAUTHORIZED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.NO_CONTENT, description = HttpStatusCode.NO_CONTENT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @DeleteMapping(value = RestControllerConstants.DELETE_PATH)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        getCertificateService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
