package com.dish.ext.demo.model.payload;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"requestContext", "transactionName", "adapterXmlRequest"})
public class Payload {

    @JsonProperty("requestContext")
    private RequestContext requestContext;

    @JsonProperty("transactionName")
    private String transactionName;

    @JsonProperty("adapterXmlRequest")
    private String adapterXmlRequest;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The requestContext
     */
    @JsonProperty("requestContext")
    public RequestContext getRequestContext() {
        return requestContext;
    }

    /**
     * @param requestContext The requestContext
     */
    @JsonProperty("requestContext")
    public void setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    /**
     * @return The transactionName
     */
    @JsonProperty("transactionName")
    public String getTransactionName() {
        return transactionName;
    }

    /**
     * @param transactionName The transactionName
     */
    @JsonProperty("transactionName")
    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    /**
     * @return The adapterXmlRequest
     */
    @JsonProperty("adapterXmlRequest")
    public String getAdapterXmlRequest() {
        return adapterXmlRequest;
    }

    /**
     * @param adapterXmlRequest The adapterXmlRequest
     */
    @JsonProperty("adapterXmlRequest")
    public void setAdapterXmlRequest(String adapterXmlRequest) {
        this.adapterXmlRequest = adapterXmlRequest;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
