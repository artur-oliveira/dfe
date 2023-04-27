package com.softart.dferestapi.controllers;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.distribution.MdfeDfeCompression;
import com.softart.dfe.enums.mdfe.distribution.MdfeDfeSolicitation;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.mdfe.distribution.MdfeReturnDistribution;
import com.softart.dfe.models.mdfe.event.MdfeReturnEvent;
import com.softart.dfe.models.mdfe.query_receipt.MdfeReturnQueryReceipt;
import com.softart.dfe.models.mdfe.query_situation.MdfeReturnQuerySituation;
import com.softart.dfe.models.mdfe.query_unclosed.MdfeReturnQueryUnclosed;
import com.softart.dfe.models.mdfe.reception.SendMdfe;
import com.softart.dfe.models.mdfe.reception.SendMdfeReturn;
import com.softart.dfe.models.mdfe.reception_sync.Mdfe;
import com.softart.dfe.models.mdfe.reception_sync.MdfeReturn;
import com.softart.dfe.models.mdfe.status_service.MdfeReturnStatusService;
import com.softart.dferestapi.constants.HttpStatusCode;
import com.softart.dferestapi.constants.MdfeControllerConstants;
import com.softart.dferestapi.models.mdfe.event.*;
import com.softart.dferestapi.models.response.error.CommonError;
import com.softart.dferestapi.models.response.error.ValidationError;
import com.softart.dferestapi.services.mdfe.MdfeService;
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
@RequestMapping(MdfeControllerConstants.BASE_PATH)
@Getter
public final class MdfeController {

    private final MdfeService mdfeService;

    @Autowired
    public MdfeController(MdfeService mdfeService) {
        this.mdfeService = mdfeService;
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_STATUS_SERVICE_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_STATUS_SERVICE_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnStatusService.class))})
    })
    @GetMapping(value = MdfeControllerConstants.STATUS_SERVICE_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnStatusService> statusService(@RequestParam("uf") Optional<UF> uf, @RequestParam("tpAmb") Optional<Environment> environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().statusService(uf.orElse(null), environment.orElse(null)));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_DISTRIBUTION_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_DISTRIBUTION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnDistribution.class))})
    })
    @GetMapping(value = MdfeControllerConstants.DISTRIBUTION_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnDistribution> distribution(@RequestParam("ultNSU") Optional<Long> ultNSU, @RequestParam("indDFe") Optional<MdfeDfeSolicitation> solicitation, @RequestParam("indCompRet") Optional<MdfeDfeCompression> compression, @RequestParam("tpAmb") Optional<Environment> tpAmb) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().distribution(ultNSU.orElse(null), solicitation.orElse(null), compression.orElse(null), tpAmb.orElse(null)));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_QUERY_UNCLOSED_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_QUERY_UNCLOSED_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnQueryUnclosed.class))})
    })
    @GetMapping(value = MdfeControllerConstants.QUERY_UNCLOSED_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnQueryUnclosed> unclosed(@RequestParam("tpAmb") Optional<Environment> environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().unclosed(environment.orElse(null)));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_QUERY_SITUATION_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_QUERY_SITUATION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnQuerySituation.class))})
    })
    @GetMapping(value = MdfeControllerConstants.QUERY_SITUATION_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnQuerySituation> querySituation(@RequestParam("chMDFe") @Size(min = 44, max = 44) String chMDFe, @RequestParam("tpAmb") Optional<Environment> tpAmb) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().querySituation(chMDFe, tpAmb.orElse(null)));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_QUERY_RECEIPT_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_QUERY_RECEIPT_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnQueryReceipt.class))})
    })
    @GetMapping(value = MdfeControllerConstants.QUERY_RECEIPT_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnQueryReceipt> queryReceipt(@RequestParam("nRec") String nRec, @RequestParam("tpAmb") Optional<Environment> environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().queryReceipt(nRec, environment.orElse(null)));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_RECEPTION_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_RECEPTION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SendMdfeReturn.class))})
    })
    @PostMapping(value = MdfeControllerConstants.RECEPTION_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SendMdfeReturn> reception(@Valid @RequestBody SendMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().reception(o));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_RECEPTION_SYNC_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_RECEPTION_SYNC_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturn.class))})
    })
    @PostMapping(value = MdfeControllerConstants.RECEPTION_SYNC_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturn> receptionSync(@Valid @RequestBody Mdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().receptionSync(o));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_CANCEL_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_CANCEL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnEvent.class))})
    })
    @PostMapping(value = MdfeControllerConstants.CANCEL_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnEvent> cancel(@PathVariable("chMDFe") String chMDFe, @Valid @RequestBody CancelMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().cancel(o.withChMDFe(chMDFe)));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_CLOSE_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_CLOSE_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnEvent.class))})
    })
    @PostMapping(value = MdfeControllerConstants.CLOSE_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnEvent> close(@PathVariable("chMDFe") String chMDFe, @Valid @RequestBody CloseMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().close(o.withChMDFe(chMDFe)));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_DFE_INCLUSION_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_DFE_INCLUSION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnEvent.class))})
    })
    @PostMapping(value = MdfeControllerConstants.DFE_INCLUSION_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnEvent> dfeInclusion(@PathVariable("chMDFe") String chMDFe, @Valid @RequestBody DfeInclusionMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().dfeInclusion(o.withChMDFe(chMDFe)));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_DRIVER_INCLUSION_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_DRIVER_INCLUSION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnEvent.class))})
    })
    @PostMapping(value = MdfeControllerConstants.DRIVER_INCLUSION_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnEvent> driverInclusion(@PathVariable("chMDFe") String chMDFe, @Valid @RequestBody DriverInclusionMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().driverInclusion(o.withChMDFe(chMDFe)));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_PAYMENT_MODIFICATION_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_PAYMENT_MODIFICATION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnEvent.class))})
    })
    @PostMapping(value = MdfeControllerConstants.PAYMENT_MODIFICATION_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnEvent> paymentModification(@PathVariable("chMDFe") String chMDFe, @Valid @RequestBody PaymentModificationMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().paymentModification(o.withChMDFe(chMDFe)));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_PAYMENT_OPERATION_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_PAYMENT_OPERATION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnEvent.class))})
    })
    @PostMapping(value = MdfeControllerConstants.PAYMENT_OPERATION_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnEvent> paymentOperation(@PathVariable("chMDFe") String chMDFe, @Valid @RequestBody PaymentOperationMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().paymentOperation(o.withChMDFe(chMDFe)));
    }

    @Operation(summary = MdfeControllerConstants.OPEN_API_TRANSPORT_CONFIRMATION_SUMMARY, tags = MdfeControllerConstants.OPEN_API_TAG, description = MdfeControllerConstants.OPEN_API_TRANSPORT_CONFIRMATION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MdfeReturnEvent.class))})
    })
    @PostMapping(value = MdfeControllerConstants.TRANSPORT_CONFIRMATION_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MdfeReturnEvent> transportConfirmation(@PathVariable("chMDFe") String chMDFe, @Valid @RequestBody TransportConfirmationMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getMdfeService().transportConfirmation(o.withChMDFe(chMDFe)));
    }
}
