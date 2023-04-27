package com.softart.dferestapi.controllers;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.nf.authorization.ReturnSendNf;
import com.softart.dfe.models.nf.authorization.SendNf;
import com.softart.dfe.models.nf.cancel.ReturnNfeCancel;
import com.softart.dfe.models.nf.inut.ReturnNfeInut;
import com.softart.dfe.models.nf.query_protocol.ReturnQueryProtocolNfe;
import com.softart.dfe.models.nf.query_status_service.ReturnQueryStatusServiceNf;
import com.softart.dfe.models.nf.return_authorization.ReturnQueryReceiptNfe;
import com.softart.dfe.models.nf.substitute_cancel.ReturnNfceSubstituteCancel;
import com.softart.dferestapi.constants.HttpStatusCode;
import com.softart.dferestapi.constants.NfceControllerConstants;
import com.softart.dferestapi.models.nfe.event.CancelMultipleNfe;
import com.softart.dferestapi.models.nfe.event.CancelNfe;
import com.softart.dferestapi.models.nfe.event.SubstituteCancelMultipleNfce;
import com.softart.dferestapi.models.nfe.event.SubstituteCancelNfce;
import com.softart.dferestapi.models.nfe.inutilization.Inutilization;
import com.softart.dferestapi.models.response.error.CommonError;
import com.softart.dferestapi.models.response.error.ValidationError;
import com.softart.dferestapi.services.nfce.NfceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Optional;

@RestController
@RequestMapping(NfceControllerConstants.BASE_PATH)
@Getter
public final class NfceController {

    private final NfceService nfceService;

    @Autowired
    public NfceController(NfceService nfceService) {
        this.nfceService = nfceService;
    }

    @Operation(summary = NfceControllerConstants.OPEN_API_AUTHORIZATION_SUMMARY, tags = NfceControllerConstants.OPEN_API_TAG, description = NfceControllerConstants.OPEN_API_AUTHORIZATION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReturnSendNf.class))})
    })
    @PostMapping(value = NfceControllerConstants.AUTHORIZATION_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReturnSendNf> authorization(@Valid @RequestBody SendNf nf) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getNfceService().authorization(nf));
    }

    @Operation(summary = NfceControllerConstants.OPEN_API_CANCEL_SUMMARY, tags = NfceControllerConstants.OPEN_API_TAG, description = NfceControllerConstants.OPEN_API_CANCEL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReturnNfeCancel.class))})
    })
    @PostMapping(value = NfceControllerConstants.CANCEL_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReturnNfeCancel> cancel(@Valid @RequestBody CancelMultipleNfe cancelMultipleNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getNfceService().cancel(cancelMultipleNfe));
    }

    @Operation(summary = NfceControllerConstants.OPEN_API_SIMPLE_CANCEL_SUMMARY, tags = NfceControllerConstants.OPEN_API_TAG, description = NfceControllerConstants.OPEN_API_SIMPLE_CANCEL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReturnNfeCancel.class))})
    })
    @PostMapping(value = NfceControllerConstants.SIMPLE_CANCEL_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReturnNfeCancel> cancelAccessKey(@PathVariable("chNFe") String accessKey, @Valid @RequestBody CancelNfe cancelNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getNfceService().cancel(cancelNfe.withChNFe(accessKey)));
    }

    @Operation(summary = NfceControllerConstants.OPEN_API_INUTILIZATION_SUMMARY, tags = NfceControllerConstants.OPEN_API_TAG, description = NfceControllerConstants.OPEN_API_INUTILIZATION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReturnNfeInut.class))})
    })
    @PostMapping(value = NfceControllerConstants.INUTILIZATION_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReturnNfeInut> inutilization(@Valid @RequestBody Inutilization o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getNfceService().inutilization(o));
    }

    @Operation(summary = NfceControllerConstants.OPEN_API_SUBSTITUTE_CANCEL_SUMMARY, tags = NfceControllerConstants.OPEN_API_TAG, description = NfceControllerConstants.OPEN_API_SUBSTITUTE_CANCEL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReturnNfceSubstituteCancel.class))})
    })
    @PostMapping(value = NfceControllerConstants.SUBSTITUTE_CANCEL_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReturnNfceSubstituteCancel> substituteCancel(@Valid @RequestBody SubstituteCancelMultipleNfce o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getNfceService().substituteCancel(o));
    }

    @Operation(summary = NfceControllerConstants.OPEN_API_SIMPLE_SUBSTITUTE_CANCEL_SUMMARY, tags = NfceControllerConstants.OPEN_API_TAG, description = NfceControllerConstants.OPEN_API_SIMPLE_SUBSTITUTE_CANCEL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReturnNfceSubstituteCancel.class))})
    })
    @PostMapping(value = NfceControllerConstants.SIMPLE_SUBSTITUTE_CANCEL_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReturnNfceSubstituteCancel> substituteCancelAccessKey(@PathVariable("chNFe") String accessKey, @PathVariable("chNFeRef") String accessKeyRef, @Valid @RequestBody SubstituteCancelNfce o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getNfceService().substituteCancel(o.withChNFe(accessKey).withChNFeRef(accessKeyRef)));
    }

    @Operation(summary = NfceControllerConstants.OPEN_API_QUERY_RECEIPT_SUMMARY, tags = NfceControllerConstants.OPEN_API_TAG, description = NfceControllerConstants.OPEN_API_QUERY_RECEIPT_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReturnQueryReceiptNfe.class))})
    })
    @GetMapping(value = NfceControllerConstants.QUERY_RECEIPT_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReturnQueryReceiptNfe> queryReceipt(@RequestParam("nRec") String nRec, @RequestParam("tpAmb") Optional<Environment> environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getNfceService().queryReceipt(nRec, environment.orElse(null)));
    }

    @Operation(summary = NfceControllerConstants.OPEN_API_QUERY_PROTOCOL_SUMMARY, tags = NfceControllerConstants.OPEN_API_TAG, description = NfceControllerConstants.OPEN_API_QUERY_PROTOCOL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReturnQueryProtocolNfe.class))})
    })
    @GetMapping(value = NfceControllerConstants.QUERY_PROTOCOL_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReturnQueryProtocolNfe> queryProtocol(@RequestParam("chNFe") @Size(min = 44, max = 44) String accessKey, @RequestParam("tpAmb") Optional<Environment> environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getNfceService().queryProtocol(accessKey, environment.orElse(null)));
    }

    @Operation(summary = NfceControllerConstants.OPEN_API_STATUS_SERVICE_SUMMARY, tags = NfceControllerConstants.OPEN_API_TAG, description = NfceControllerConstants.OPEN_API_STATUS_SERVICE_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReturnQueryProtocolNfe.class))})
    })
    @GetMapping(value = NfceControllerConstants.STATUS_SERVICE_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReturnQueryStatusServiceNf> statusService(@RequestParam("uf") Optional<UF> uf, @RequestParam("tpAmb") Optional<Environment> environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getNfceService().queryStatusService(uf.orElse(null), environment.orElse(null)));
    }
}
