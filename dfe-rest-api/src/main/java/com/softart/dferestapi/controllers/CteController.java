package com.softart.dferestapi.controllers;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.cte.distribution.CteReturnDistribution;
import com.softart.dfe.models.cte.event.CteReturnEvent;
import com.softart.dfe.models.cte.inutilization.CteReturnInutilization;
import com.softart.dfe.models.cte.query_receipt.ReturnQueryReceipt;
import com.softart.dfe.models.cte.query_situation.CteReturnQuerySituation;
import com.softart.dfe.models.cte.reception.Cte;
import com.softart.dfe.models.cte.reception.CteReturnSend;
import com.softart.dfe.models.cte.reception.CteSend;
import com.softart.dfe.models.cte.reception_gtve.Gtve;
import com.softart.dfe.models.cte.reception_gtve.GtveReturn;
import com.softart.dfe.models.cte.reception_os.CteOs;
import com.softart.dfe.models.cte.reception_os.CteOsReturn;
import com.softart.dfe.models.cte.reception_sync.CteReturn;
import com.softart.dfe.models.cte.status_service.CteReturnStatusService;
import com.softart.dferestapi.constants.CteControllerConstants;
import com.softart.dferestapi.constants.HttpStatusCode;
import com.softart.dferestapi.models.cte.event.*;
import com.softart.dferestapi.models.cte.inutilization.Inutilization;
import com.softart.dferestapi.models.response.error.CommonError;
import com.softart.dferestapi.models.response.error.ValidationError;
import com.softart.dferestapi.services.cte.CteService;
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
@RequestMapping(CteControllerConstants.BASE_PATH)
@Getter
public final class CteController {

    private final CteService cteService;

    @Autowired
    public CteController(CteService cteService) {
        this.cteService = cteService;
    }

    @Operation(summary = CteControllerConstants.OPEN_API_STATUS_SERVICE_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_STATUS_SERVICE_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnStatusService.class))})
    })
    @GetMapping(value = CteControllerConstants.STATUS_SERVICE_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnStatusService> statusService(@RequestParam("uf") Optional<UF> uf, @RequestParam("tpAmb") Optional<Environment> environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().statusService(uf.orElse(null), environment.orElse(null)));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_DISTRIBUTION_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_DISTRIBUTION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnDistribution.class))})
    })
    @GetMapping(value = CteControllerConstants.DISTRIBUTION_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnDistribution> distribution(@RequestParam("ultNSU") Optional<Long> ultNSU, @RequestParam("nsu") Optional<Long> nsu, @RequestParam("tpAmb") Optional<Environment> tpAmb) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().distribution(ultNSU.orElse(null), nsu.orElse(null), tpAmb.orElse(null)));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_QUERY_SITUATION_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_QUERY_SITUATION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnQuerySituation.class))})
    })
    @GetMapping(value = CteControllerConstants.QUERY_SITUATION_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnQuerySituation> querySituation(@RequestParam("chCTe") @Size(min = 44, max = 44) String chCTe, @RequestParam("tpAmb") Optional<Environment> environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().querySituation(chCTe, environment.orElse(null)));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_QUERY_RECEIPT_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_QUERY_RECEIPT_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReturnQueryReceipt.class))})
    })
    @GetMapping(value = CteControllerConstants.QUERY_RECEIPT_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReturnQueryReceipt> queryReceipt(@RequestParam("nRec") String nRec, @RequestParam("tpAmb") Optional<Environment> environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().queryReceipt(nRec, environment.orElse(null)));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_INUTILIZATION_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_INUTILIZATION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnInutilization.class))})
    })
    @PostMapping(value = CteControllerConstants.INUTILIZATION_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnInutilization> inutilization(@Valid @RequestBody Inutilization o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().inutilization(o));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_RECEPTION_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_RECEPTION_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnSend.class))})
    })
    @PostMapping(value = CteControllerConstants.RECEPTION_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnSend> reception(@Valid @RequestBody CteSend cteSend) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().reception(cteSend));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_RECEPTION_SYNC_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_RECEPTION_SYNC_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturn.class))})
    })
    @PostMapping(value = CteControllerConstants.RECEPTION_SYNC_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturn> receptionSync(@Valid @RequestBody Cte cteSend) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().receptionSync(cteSend));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_RECEPTION_OS_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_RECEPTION_OS_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteOsReturn.class))})
    })
    @PostMapping(value = CteControllerConstants.RECEPTION_OS_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteOsReturn> receptionOs(@Valid @RequestBody CteOs o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().receptionOs(o));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_RECEPTION_GTVE_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_RECEPTION_GTVE_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GtveReturn.class))})
    })
    @PostMapping(value = CteControllerConstants.RECEPTION_GTVE_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<GtveReturn> receptionGtve(@Valid @RequestBody Gtve o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().receptionGtve(o));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_CANCEL_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_CANCEL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnEvent.class))})
    })
    @PostMapping(value = CteControllerConstants.CANCEL_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnEvent> cancel(@PathVariable("chCTe") String chCTe, @Valid @RequestBody CancelCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().cancel(o.withChCTe(chCTe)));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_CORRECTION_LETTER_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_CORRECTION_LETTER_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnEvent.class))})
    })
    @PostMapping(value = CteControllerConstants.CORRECTION_LETTER_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnEvent> correctionLetter(@PathVariable("chCTe") String chCTe, @Valid @RequestBody CorrectionLetterCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().correctionLetter(o.withChCTe(chCTe)));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_DELIVERY_RECEIPT_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_DELIVERY_RECEIPT_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnEvent.class))})
    })
    @PostMapping(value = CteControllerConstants.DELIVERY_RECEIPT_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnEvent> deliveryReceipt(@PathVariable("chCTe") String chCTe, @Valid @RequestBody DeliveryReceiptCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().deliveryReceipt(o.withChCTe(chCTe)));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_CANCEL_DELIVERY_RECEIPT_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_CANCEL_DELIVERY_RECEIPT_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnEvent.class))})
    })
    @PostMapping(value = CteControllerConstants.CANCEL_DELIVERY_RECEIPT_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnEvent> cancelDeliveryReceipt(@PathVariable("chCTe") String chCTe, @Valid @RequestBody CancelDeliveryReceiptCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().cancelDeliveryReceipt(o.withChCTe(chCTe)));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_EPEC_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_EPEC_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnEvent.class))})
    })
    @PostMapping(value = CteControllerConstants.EPEC_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnEvent> epec(@PathVariable("chCTe") String chCTe, @Valid @RequestBody EpecCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().epec(o.withChCTe(chCTe)));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_GTV_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_GTV_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnEvent.class))})
    })
    @PostMapping(value = CteControllerConstants.GTV_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnEvent> gtv(@PathVariable("chCTe") String chCTe, @Valid @RequestBody GtvCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().gtv(o.withChCTe(chCTe)));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_PROVISION_DISAGREEMENT_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_PROVISION_DISAGREEMENT_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnEvent.class))})
    })
    @PostMapping(value = CteControllerConstants.PROVISION_DISAGREEMENT_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnEvent> provisionDisagreement(@PathVariable("chCTe") String chCTe, @Valid @RequestBody ProvisionDisagreementCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().provisionDisagreement(o.withChCTe(chCTe)));
    }

    @Operation(summary = CteControllerConstants.OPEN_API_MULTIMODAL_SUMMARY, tags = CteControllerConstants.OPEN_API_TAG, description = CteControllerConstants.OPEN_API_MULTIMODAL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR, description = HttpStatusCode.INTERNAL_SERVER_ERROR_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.BAD_REQUEST, description = HttpStatusCode.BAD_REQUEST_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.CONFLICT, description = HttpStatusCode.CONFLICT_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommonError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.UNPROCESSABLE_ENTITY, description = HttpStatusCode.UNPROCESSABLE_ENTITY_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationError.class))}),
            @ApiResponse(responseCode = HttpStatusCode.OK, description = HttpStatusCode.OK_DESCRIPTION, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CteReturnEvent.class))})
    })
    @PostMapping(value = CteControllerConstants.MULTIMODAL_PATH, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CteReturnEvent> multimodal(@PathVariable("chCTe") String chCTe, @Valid @RequestBody MultimodalCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return ResponseEntity.ok(getCteService().multimodal(o.withChCTe(chCTe)));
    }

}
