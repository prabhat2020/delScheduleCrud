package com.tcs.service.controller

import com.microsoft.applicationinsights.TelemetryClient
import com.tcs.service.model.BaseModel
import com.tcs.service.model.ServiceResponse
import com.tcs.service.model.deliveryScheduleModel
import com.tcs.service.service.DeliveryScheduleCrudService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.apache.logging.log4j.kotlin.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.ExampleMatcher
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/service-template")
@Tag(name = "BaseAPI", description = "The Base API")
class DeliveryScheduleCrudController(private val service: DeliveryScheduleCrudService) {

    val logger = logger()

    /**
     * TelemetryClient is responsible for sending events to App Insights
     */
    @Autowired
    lateinit var telemetryClient: TelemetryClient

    /**
     * This is a sample of the GET Endpoint
     */
    @Operation(summary = "Get Model", description = "Get Model", tags = ["BaseAPI"])
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found Model", content = [
            (Content(mediaType = "application/json", array = (
                    ArraySchema(schema = Schema(implementation = BaseModel::class)))))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find any BaseModel", content = [Content()])]
    )
    @RequestMapping(value = ["/model"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getBaseModel(@RequestParam() storeNumber:Long?, @RequestParam(required = false) deliveryStreamNumber:Int?): ResponseEntity<ServiceResponse> {
        logger.info("Inside Base Controller")
        telemetryClient.trackEvent("URI /model is triggered");
        print(storeNumber)
        print(deliveryStreamNumber)
        return ResponseEntity.ok(ServiceResponse("200",
                "SUCCESS", service.getbyquery(storeNumber,deliveryStreamNumber)))
    }

    @RequestMapping(value = ["/model"], method = [RequestMethod.POST], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun saveModel(@RequestBody baseModel: deliveryScheduleModel): ResponseEntity<ServiceResponse>? {
        println(baseModel)
        service.saveSchedule(baseModel)


        return ResponseEntity.ok(ServiceResponse("200",
                "SUCCESS", "Data Successfully Inserted"))

    }

}