package com.dish.ext.demo.api;

import com.dish.ext.demo.converter.ServiceResponseContextConverter;
import com.dish.ext.demo.processor.TaxProcessor;
import com.dish.ext.demo.util.AdapterErrorConfig;
import com.dish.ext.demo.util.GetToString;
import com.dish.wsdl.demo.demo_v1.GetTaxQuoteRequest;
import com.dish.wsdl.demo.demo_v1.GetTaxQuoteResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Arrays;
import java.util.Date;

@Endpoint
@Slf4j
public class DemoEndPoint {
    private static final String NAMESPACE_URI = "http://www.dish.com/wsdl/Demo/Demo-v1.0";
    public static String[] cftNamesArr;

    @Value("${cft.names}")
    public String cftNames;

    @Autowired
    ServiceResponseContextConverter serviceResponseContextConverter;

    @Autowired
    private TaxProcessor taxProcessor;

    @Autowired
    private GetToString getToString;

    @Autowired
    private AdapterErrorConfig adapterErrorConfig;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTaxQuoteRequest")
    @ResponsePayload
    public GetTaxQuoteResponse getTaxQuote(@RequestPayload GetTaxQuoteRequest request)
            throws Exception {

        log.info("*** Start of getTaxQuote() ***");

        GetTaxQuoteResponse getTaxQuoteResponse = new GetTaxQuoteResponse();
        Date requestReceived = new Date();
        String statusCode = adapterErrorConfig.getStatusCode();
        String statusMessage = adapterErrorConfig.getStatusMessage();
        String displayMessage = adapterErrorConfig.getDisplayMessage();
        String customerFacingTool = null;
        cftNamesArr = cftNames.split(",");

        if (request == null || request.getServiceRequestContext() == null) {
            log.warn("request is not valid");
            getTaxQuoteResponse.setServiceResponseContext(serviceResponseContextConverter.
                    getOutputContext(requestReceived, request.getServiceRequestContext(), "1001",
                            "Request is null or blank ", "Request is null or blank "));
            return getTaxQuoteResponse;
        }
        if (null == request.getServiceRequestContext().getServiceInteraction() ||
                null == request.getServiceRequestContext().getServiceInteraction()
                        .getInteractionId() ||
                request.getServiceRequestContext().getServiceInteraction().getInteractionId().trim()
                        .equals("")) {
            log.warn("Interaction id is not valid");
            getTaxQuoteResponse.setServiceResponseContext(serviceResponseContextConverter.
                    getOutputContext(requestReceived, request.getServiceRequestContext(), "1001",
                            "Please provide valid Interaction id ",
                            "Please provide valid Interaction id "));
            return getTaxQuoteResponse;
        }

        if (null == request.getServiceRequestContext().getServiceInteraction() ||
                null == request.getServiceRequestContext().getServiceInteraction()
                        .getCustomerFacingTool() ||
                request.getServiceRequestContext().getServiceInteraction()
                        .getCustomerFacingTool().trim().equals("")) {
            log.warn("customerFacingTool hasn't been provided in request");
            getTaxQuoteResponse.setServiceResponseContext(serviceResponseContextConverter.
                    getOutputContext(requestReceived, request.getServiceRequestContext(), "1001",
                            "customerFacingTool hasn't been provided in request ",
                            "customerFacingTool hasn't been provided in request "));
            return getTaxQuoteResponse;
        }

        customerFacingTool = request.getServiceRequestContext().getServiceInteraction()
                .getCustomerFacingTool().trim();

        boolean cftValid = Arrays.asList(cftNamesArr).contains(customerFacingTool);
        if (!cftValid) {
            log.warn("customerFacingTool is not valid");
            getTaxQuoteResponse.setServiceResponseContext(serviceResponseContextConverter.
                    getOutputContext(requestReceived, request.getServiceRequestContext(), "1001",
                            "CustomerFacingTool " + customerFacingTool + " is not found in data. ",
                            "CustomerFacingTool " + customerFacingTool
                                    + " is not found in data. "));
            return getTaxQuoteResponse;
        }

        if (null == request.getGetTaxQuoteInput() || null == request.getGetTaxQuoteInput()
                .getLocation() || null == request.getGetTaxQuoteInput().getLocation()
                .getGeographical() || null == request.getGetTaxQuoteInput().getLocation()
                .getGeographical().getVertexCode() ||
                request.getGetTaxQuoteInput().getLocation().getGeographical().getVertexCode()
                        .toString().length() != 9) {
            log.warn("VertexCode is not valid");
            getTaxQuoteResponse.setServiceResponseContext(serviceResponseContextConverter.
                    getOutputContext(requestReceived, request.getServiceRequestContext(),
                            statusCode, statusMessage + " invalid vertex code", displayMessage));
            return getTaxQuoteResponse;

        }

        if (null == request.getGetTaxQuoteInput() || null == request.getGetTaxQuoteInput()
                .getItemList() || ""
                .equalsIgnoreCase(request.getGetTaxQuoteInput().getItemList().toString())) {
            log.warn("Please provide valid ItemList ");
            getTaxQuoteResponse.setServiceResponseContext(serviceResponseContextConverter.
                    getOutputContext(requestReceived, request.getServiceRequestContext(),
                            statusCode, statusMessage
                                    + " Invalid ItemList: Item Code or Billing Charge is missing or invalid",
                            displayMessage));
            return getTaxQuoteResponse;
        }

        log.info("Received request GetTaxQuoteRequest : " + getToString.toString(request));

        try {
            getTaxQuoteResponse = taxProcessor.processRequest(request);

            //Setting default values
            String code = null;
            String statusMes = null;
            String displayMes = null;

            if (getTaxQuoteResponse.getServiceResponseContext() != null) {
                code = ((getTaxQuoteResponse.getServiceResponseContext().getStatusCode() == null) ?
                        "0" :
                        getTaxQuoteResponse.getServiceResponseContext().getStatusCode());
                statusMes = getTaxQuoteResponse.getServiceResponseContext().getStatusMessage();
                displayMes = getTaxQuoteResponse.getServiceResponseContext().getDisplayMessage();
            }
            getTaxQuoteResponse.setServiceResponseContext(serviceResponseContextConverter.
                    getOutputContext(requestReceived, request.getServiceRequestContext(), code,
                            statusMes, displayMes));
            log.info("*** End of getTaxQuoteInfo(). Returning response getTaxQuoteResponse : "
                    + getToString.toString(getTaxQuoteResponse));

        } catch (Exception ex) {
            log.info("Exception in getTaxQuoteInfo():  " + ex.getMessage()
                    + "| GetTaxQuoteRequest :" + getToString.toString(request));
            getTaxQuoteResponse.setServiceResponseContext(serviceResponseContextConverter.
                    getOutputContext(requestReceived, request.getServiceRequestContext(),
                            statusCode, ex.getMessage(), ex.getMessage()));

            return getTaxQuoteResponse;
        }
        return getTaxQuoteResponse;
    }
}