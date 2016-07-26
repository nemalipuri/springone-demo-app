package com.dish.ext.demo.util;

import com.dish.wsdl.demo.demo_v1.GetTaxQuoteRequest;
import com.dish.wsdl.demo.demo_v1.GetTaxQuoteResponse;
import org.springframework.stereotype.Component;

@Component
public class GetToString {

    public String toString(GetTaxQuoteResponse getTaxQuoteResponse) {
        return "GetTaxQuoteResponse{" +
                "serviceResponseContext=" + getTaxQuoteResponse.getServiceResponseContext() +
                ", getTaxQuoteOutput=" + getTaxQuoteResponse.getGetTaxQuoteOutput() +
                '}';
    }

    public String toString(GetTaxQuoteRequest getTaxQuoteRequest) {
        return "GetTaxQuoteRequest{" +
                "serviceRequestContext=" + getTaxQuoteRequest.getServiceRequestContext() +
                ", getTaxQuoteInput=" + getTaxQuoteRequest.getGetTaxQuoteInput() +
                '}';
    }
}
