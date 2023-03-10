package com.softart.dferestapi.controllers;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/company")
@Getter
public final class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Operation(summary = "Listagem de estabelecimentos", tags = "Estabelecimentos", description = "Lista os estabelecimentos que o usuário possui accesso")
    @ApiResponses({
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "200", description = "Ok", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ListResponse.CompanyListResponse.class))})
    })
    @GetMapping(value = "/")
    public ResponseEntity<ListResponse<CompanyDTO>> findAll() {
        ListResponse<CompanyDTO> response = new ListResponse<>(getCompanyService().findAll().stream().map(CompanyDTO::new).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Criação de estabelecimentos", tags = "Estabelecimentos", description = "Cria um novo estabelecimento")
    @ApiResponses({
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "409", description = "Conflict", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = "200", description = "Ok", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CompanyDTO.class))})
    })
    @PostMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<CompanyDTO> create(@Valid @RequestBody CompanyRequest companyRequest) {
        return ResponseEntity.ok(new CompanyDTO(getCompanyService().createCompany(companyRequest)));
    }

    @Operation(summary = "Detalhamento de estabelecimentos", tags = "Estabelecimentos", description = "Detalha um estabelecimento")
    @ApiResponses({
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = "200", description = "Ok", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CompanyDTO.class))})
    })
    @GetMapping(value = "/{id}/")
    public ResponseEntity<CompanyDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new CompanyDTO(getCompanyService().findById(id)));
    }

    @Operation(summary = "Atualização de estabelecimentos", tags = "Estabelecimentos", description = "Atualiza um estabelecimento")
    @ApiResponses({
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = "200", description = "Ok", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CompanyDTO.class))})
    })
    @PutMapping(value = "/{id}/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<CompanyDTO> update(@PathVariable Long id, @Valid @RequestBody CompanyUpdateRequest companyUpdateRequest) {
        companyUpdateRequest.setId(id);
        return ResponseEntity.ok(new CompanyDTO(getCompanyService().updateCompany(companyUpdateRequest)));
    }

    @Operation(summary = "Atualização parcial de estabelecimentos", tags = "Estabelecimentos", description = "Atualiza partialmente um estabelecimento")
    @ApiResponses({
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = "200", description = "Ok", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CompanyDTO.class))})
    })
    @PatchMapping(value = "/{id}/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<CompanyDTO> updatePartial(@PathVariable Long id, @Valid @RequestBody CompanyPartialUpdateRequest companyUpdateRequest) {
        companyUpdateRequest.setId(id);
        return ResponseEntity.ok(new CompanyDTO(getCompanyService().partialUpdateCompany(companyUpdateRequest)));
    }
}
