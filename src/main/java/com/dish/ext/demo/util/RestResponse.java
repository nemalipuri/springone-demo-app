package com.dish.ext.demo.util;

import com.dish.ext.demo.model.rest.DemoServiceResponse;
import com.dish.ext.demo.model.rest.ResponseContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.dish.ext.demo.model.rest.ResponseContextBuilder.responseContextBuilder;

public class RestResponse {

    private RestResponse() {
    }

    public static ResponseEntity<DemoServiceResponse> prepareRestResponse(String iid,
                                                                          String requestId, String reqTimestamp, String responseTimestamp, String statusCode,
                                                                          String statusMessage, String displayMessage) {
        DemoServiceResponse demoServiceResponse = new DemoServiceResponse();
        ResponseContext responseContext = prepareResponseContext(iid, requestId, reqTimestamp,
                responseTimestamp, statusCode, statusMessage, displayMessage);
        demoServiceResponse.setResponseContext(responseContext);
        return new ResponseEntity<DemoServiceResponse>(demoServiceResponse,
                HttpStatus.OK);
    }

    public static ResponseContext prepareResponseContext(String iid, String requestId,
                                                         String reqTimestamp, String responseTimestamp, String statusCode, String statusMessage,
                                                         String displayMessage) {
        return responseContextBuilder().interactionId(iid).requestId(requestId)
                .requestReceivedTimestamp(reqTimestamp)
                .responseGeneratedTimestamp(responseTimestamp).statusCode(statusCode)
                .statusMessage(statusMessage).displayMessage(displayMessage).build();
    }

}
