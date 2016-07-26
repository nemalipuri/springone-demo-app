package com.dish.ext.demo.processor;

import com.dish.ext.demo.converter.GetTaxQuoteRequestConverter;
import com.dish.ext.demo.converter.GetTaxQuoteResponseConverter;
import com.dish.ext.demo.model.payload.Payload;
import com.dish.ext.demo.model.remote.SmartlinkAdapterRestResponse;
import com.dish.ext.demo.util.GetToString;
import com.dish.wsdl.demo.demo_v1.GetTaxQuoteRequest;
import com.dish.wsdl.demo.demo_v1.GetTaxQuoteResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Handle the calls forwarded by Controller
 */
@Slf4j
@Component
public class TaxProcessor {

    @Autowired
    public GetTaxQuoteResponseConverter getTaxQuoteResponseConverter;

    @Autowired
    public GetTaxQuoteRequestConverter getTaxQuoteRequestConverter;
    @Autowired
    public RestTemplate restTemplate;
    @Value("${adapter-api-app.uri}")
    public String appUri;
    @Value("${message.getTaxQuote.other.statusCode}")
    public String statusCode;
    @Value("${message.getTaxQuote.other.statusMessage}")
    public String statusMessage;
    @Value("${message.getTaxQuote.other.displayMessage}")
    public String displayMessage;
    @Autowired
    private GetToString getToString;

    public TaxProcessor() {
    }

    public TaxProcessor(GetTaxQuoteResponseConverter getTaxQuoteResponseConverter,
                        GetTaxQuoteRequestConverter getTaxQuoteRequestConverter, RestTemplate restTemplate,
                        GetToString getToString, String appUri, String statusCode, String statusMessage,
                        String displayMessage) {
        this.getTaxQuoteResponseConverter = getTaxQuoteResponseConverter;
        this.getTaxQuoteRequestConverter = getTaxQuoteRequestConverter;
        this.restTemplate = restTemplate;
        this.getToString = getToString;
        this.appUri = appUri;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.displayMessage = displayMessage;
    }

    @Bean
    public RestTemplate restTemplate(@Value("${adapter-api-app.readTimeOut}") String readTimeOut) {

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(Integer.parseInt(readTimeOut));
        return new RestTemplate(factory);

    }

    public GetTaxQuoteResponse processRequest(GetTaxQuoteRequest request) throws Exception {

        log.info("Processing request for getTaxQuote()" + " | GetTaxQuoteRequest : " + getToString
                .toString(request));

        GetTaxQuoteResponse getTaxQuoteResponse;
        SmartlinkAdapterRestResponse smartlinkAdapterRestResponse;

        // mapRequest GetTaxQuoteRequest to Payload class
        Payload payload = getTaxQuoteRequestConverter.mapRequest(request);
        ResponseEntity<SmartlinkAdapterRestResponse> response = null;

        log.debug(
                "Request Payload :" + payload.toString() + " | GetTaxQuoteRequest : " + getToString
                        .toString(request));

        String errorMessage = null;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(payload, headers);

        try {
            response = restTemplate.exchange(appUri, HttpMethod.POST, entity,
                    SmartlinkAdapterRestResponse.class);
        } catch (Exception ex) {
            log.info("Exception in adapter call: " + ex.getMessage() + " | GetTaxQuoteRequest : "
                    + getToString.toString(request));
            errorMessage = ex.getMessage();
        }
        if (response != null) {

            log.debug(
                    "Response from adapter call :" + response.toString() + " | GetTaxQuoteRequest : "
                            + getToString.toString(request));
            smartlinkAdapterRestResponse = response.getBody();

            if (smartlinkAdapterRestResponse != null) {
                log.info("Mapping response" + " | GetTaxQuoteRequest : " + getToString
                        .toString(request));
                // mapRequest SmartlinkAdapterRestResponse to GetTaxQuoteResponse class
                getTaxQuoteResponse = getTaxQuoteResponseConverter
                        .mapResponse(smartlinkAdapterRestResponse);
            } else {
                log.info("Adapter response is null" + " | GetTaxQuoteRequest : " + getToString
                        .toString(request));
                // mapResponseContext to error if adapter response is null
                getTaxQuoteResponse = getTaxQuoteResponseConverter
                        .mapResponseContext(displayMessage, statusMessage, statusCode);
            }
        } else {
            log.info("Response is null" + " | GetTaxQuoteRequest : " + getToString
                    .toString(request));
            // mapResponseContext to error if adapter response is null
            getTaxQuoteResponse = getTaxQuoteResponseConverter
                    .mapResponseContext(errorMessage, errorMessage, statusCode);
        }
        return getTaxQuoteResponse;
    }
}
