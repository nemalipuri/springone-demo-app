package com.dish.ext.demo.processor;

import com.dish.ext.demo.model.rest.DemoServiceRequest;
import com.dish.ext.demo.model.rest.DemoServiceResponse;
import com.dish.ext.demo.model.rest.ResponseContext;
import com.dish.ext.demo.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoServiceProcessor {


    public DemoServiceResponse demoService(
            DemoServiceRequest demoServiceRequest) {

        log.info("*** Start of demoService() | " + demoServiceRequest + " ***");

        //initialize response
        DemoServiceResponse demoServiceResponse = new DemoServiceResponse();
        ResponseContext responseContext = new ResponseContext();
        responseContext.setStatusCode("0");
        responseContext.setStatusMessage("");
        responseContext.setDisplayMessage("");
        demoServiceResponse.setResponseContext(responseContext);

        try {

            //Business logic goes here

            return demoServiceResponse;

        } catch (Exception e) {
            log.error("Exception has been thrown ", e);
            demoServiceResponse.setResponseContext(RestResponse
                    .prepareResponseContext(null, null, null, null, "5102",
                            "Technical error occurred while processing demoService request, "
                                    + e.getMessage(),
                            "Technical error occurred while processingdemoService request."));
            return demoServiceResponse;
        }
    }

}
