package com.softart.dferestapi.controllers;

import com.softart.dferestapi.constants.CompanyControllerConstants;
import com.softart.dferestapi.constants.HttpStatusCode;
import com.softart.dferestapi.constants.RestControllerConstants;
import com.softart.dferestapi.models.company.CompanyDTO;
import com.softart.dferestapi.models.company.request.CompanyPartialUpdateRequest;
import com.softart.dferestapi.models.company.request.CompanyRequest;
import com.softart.dferestapi.models.company.request.CompanyUpdateRequest;
import com.softart.dferestapi.models.response.error.CommonError;
import com.softart.dferestapi.models.response.error.ValidationError;
import com.softart.dferestapi.models.response.list.ListResponse;
import com.softart.dferestapi.services.company.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping(CompanyControllerConstants.BASE_PATH)
@Getter
public final class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Operation(summary = CompanyControllerConstants.OPENAPI_LIST_SUMMARY, tags = CompanyControllerConstants.OPEN_API_TAG, description = CompanyControllerConstants.OPENAPI_LIST_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNAUTHORIZED, description = HttpStatusCode.UNAUTHORIZED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ListResponse.CompanyListResponse.class))})
    })
    @GetMapping(value = RestControllerConstants.LIST_PATH)
    public ResponseEntity<ListResponse<CompanyDTO>> findAll() {
        ListResponse<CompanyDTO> response = new ListResponse<>(getCompanyService().findAll().stream().map(CompanyDTO::new).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = CompanyControllerConstants.OPENAPI_CREATE_SUMMARY, tags = CompanyControllerConstants.OPEN_API_TAG, description = CompanyControllerConstants.OPENAPI_CREATE_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNAUTHORIZED, description = HttpStatusCode.UNAUTHORIZED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CREATED, description = HttpStatusCode.CREATED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CompanyDTO.class))})
    })
    @PostMapping(value = RestControllerConstants.CREATE_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CompanyDTO> create(@Valid @RequestBody CompanyRequest companyRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new CompanyDTO(getCompanyService().createCompany(companyRequest)));
    }

    @Operation(summary = CompanyControllerConstants.OPENAPI_DETAIL_SUMMARY, tags = CompanyControllerConstants.OPEN_API_TAG, description = CompanyControllerConstants.OPENAPI_DETAIL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNAUTHORIZED, description = HttpStatusCode.UNAUTHORIZED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.NOT_FOUND, description = HttpStatusCode.NOT_FOUND_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CompanyDTO.class))})
    })
    @GetMapping(value = RestControllerConstants.DETAIL_PATH)
    public ResponseEntity<CompanyDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new CompanyDTO(getCompanyService().findById(id)));
    }

    @Operation(summary = CompanyControllerConstants.OPENAPI_UPDATE_SUMMARY, tags = CompanyControllerConstants.OPEN_API_TAG, description = CompanyControllerConstants.OPENAPI_UPDATE_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.NOT_FOUND, description = HttpStatusCode.NOT_FOUND_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNAUTHORIZED, description = HttpStatusCode.UNAUTHORIZED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CompanyDTO.class))})
    })
    @PutMapping(value = RestControllerConstants.UPDATE_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CompanyDTO> update(@PathVariable Long id, @Valid @RequestBody CompanyUpdateRequest companyUpdateRequest) {
        companyUpdateRequest.setId(id);
        return ResponseEntity.ok(new CompanyDTO(getCompanyService().updateCompany(companyUpdateRequest)));
    }

    @Operation(summary = CompanyControllerConstants.OPENAPI_UPDATE_PARTIAL_SUMMARY, tags = CompanyControllerConstants.OPEN_API_TAG, description = CompanyControllerConstants.OPENAPI_UPDATE_PARTIAL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.NOT_FOUND, description = HttpStatusCode.NOT_FOUND_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNAUTHORIZED, description = HttpStatusCode.UNAUTHORIZED_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CompanyDTO.class))})
    })
    @PatchMapping(value = RestControllerConstants.PARTIAL_UPDATE_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CompanyDTO> updatePartial(@PathVariable Long id, @Valid @RequestBody CompanyPartialUpdateRequest companyUpdateRequest) {
        companyUpdateRequest.setId(id);
        return ResponseEntity.ok(new CompanyDTO(getCompanyService().partialUpdateCompany(companyUpdateRequest)));
    }
}
