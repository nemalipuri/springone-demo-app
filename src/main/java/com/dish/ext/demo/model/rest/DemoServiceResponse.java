package com.dish.ext.demo.model.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"responseContext"})
@Component
public class DemoServiceResponse {

    @JsonProperty("responseContext")
    private ResponseContext responseContext;

    /**
     * @return The responseContext
     */
    @JsonProperty("responseContext")
    public ResponseContext getResponseContext() {
        return responseContext;
    }

    /**
     * @param responseContext The responseContext
     */
    @JsonProperty("responseContext")
    public void setResponseContext(
            ResponseContext responseContext) {
        this.responseContext = responseContext;
    }

    @Override
    public String toString() {
        return "DemoServiceResponse{" +
                "responseContext=" + responseContext +
                '}';
    }
}
