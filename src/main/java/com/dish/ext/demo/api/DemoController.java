package com.dish.ext.demo.api;

import com.dish.ext.demo.model.rest.DemoServiceRequest;
import com.dish.ext.demo.model.rest.DemoServiceResponse;
import com.dish.ext.demo.processor.DemoServiceProcessor;
import com.dish.ext.demo.util.RestResponse;
import com.dish.ext.demo.util.TimeSource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;

@Slf4j
@RestController
@RequestMapping("rest")
@Api(value = "demo-app-controller", description = "Demo controller")
public class DemoController {

    @Autowired
    private TimeSource timeSource;

    @Autowired
    private DemoServiceProcessor demoServiceProcessor;

    @RequestMapping(value = "/method1", method = RequestMethod.POST, produces = "application/json",
            consumes = "application/json")
    @ApiOperation(
            value = "Method-1 for demo service",
            httpMethod = "POST",
            response = DemoServiceResponse.class,
            consumes = "application/json",
            produces = "application/json",
            notes = "demo app controller method-1 description")
    public ResponseEntity<DemoServiceResponse> demoMethod1(
            @RequestBody DemoServiceRequest demoServiceRequest) throws Exception {
        String requestReceivedTimestamp = timeSource.now(ZoneId.of("US/Mountain")).toString();

        log.info("*** Start of Controller: " + demoServiceRequest + " ***");

        String displayMessageForInvalidRequest = "Invalid service request";


        //validate request and requestContext
        if (null == demoServiceRequest
                || null == demoServiceRequest.getRequestContext()) {
            log.warn("Request is not valid");
            return RestResponse.prepareRestResponse(null, null, requestReceivedTimestamp,
                    timeSource.now(ZoneId.of("US/Mountain")).toString(), "9999",
                    "Request is null or blank", displayMessageForInvalidRequest);
        }

        //validate on interactionId
        if (null == demoServiceRequest.getRequestContext().getInteractionId() || "".equals(demoServiceRequest.getRequestContext().getInteractionId())) {
            //interactionId = getStatusMessageRequest.getRequestContext().getInteractionId();
            return RestResponse
                    .prepareRestResponse(null, null, requestReceivedTimestamp,
                            timeSource.now(ZoneId.of("US/Mountain")).toString(), "9999",
                            "interactionId missing from service request",
                            displayMessageForInvalidRequest);
        }

        //validate on requestId
        String requestId = ((null != demoServiceRequest.getRequestContext().getRequestId() &&
                !"".equals(demoServiceRequest.getRequestContext().getRequestId())) ?
                demoServiceRequest.getRequestContext().getRequestId() : null);

        //validate on customerFacingTool
        if (null == demoServiceRequest.getRequestContext().getCustomerFacingTool()
                || "".equals(demoServiceRequest.getRequestContext().getCustomerFacingTool())) {
            log.warn("customerFacingTool missing from service request | " + demoServiceRequest);
            return RestResponse
                    .prepareRestResponse(demoServiceRequest.getRequestContext().getInteractionId(), requestId, requestReceivedTimestamp,
                            timeSource.now(ZoneId.of("US/Mountain")).toString(), "9999",
                            "customerFacingTool missing from service request",
                            displayMessageForInvalidRequest);
        }

        //Call processor
        DemoServiceResponse demoServiceResponse = demoServiceProcessor
                .demoService(demoServiceRequest);

        //Map results
        demoServiceResponse.getResponseContext().setInteractionId(demoServiceRequest.getRequestContext().getInteractionId());
        demoServiceResponse.getResponseContext().setRequestId(requestId);
        demoServiceResponse.getResponseContext()
                .setRequestReceivedTimestamp(requestReceivedTimestamp);
        demoServiceResponse.getResponseContext()
                .setResponseGeneratedTimestamp(timeSource.now(ZoneId.of("US/Mountain")).toString());

        log.info("*** End of Controller | Response: "
                + demoServiceResponse + " | " + demoServiceRequest + " ***");

        return new ResponseEntity<DemoServiceResponse>(demoServiceResponse,
                HttpStatus.OK);
    }
}