package com.dish.ext.demo.model.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"interactionId", "requestId", "requestReceivedTimestamp",
        "responseGeneratedTimestamp", "statusCode", "statusMessage", "displayMessage"})
public class ResponseContext {

    @JsonProperty("interactionId")
    private String interactionId;

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("requestReceivedTimestamp")
    private String requestReceivedTimestamp;

    @JsonProperty("responseGeneratedTimestamp")
    private String responseGeneratedTimestamp;

    @JsonProperty("statusCode")
    private String statusCode;

    @JsonProperty("statusMessage")
    private Object statusMessage;

    @JsonProperty("displayMessage")
    private Object displayMessage;

    public ResponseContext(String interactionId, String requestId, String requestReceivedTimestamp,
                           String responseGeneratedTimestamp, String statusCode, Object statusMessage,
                           Object displayMessage) {
        this.interactionId = interactionId;
        this.requestId = requestId;
        this.requestReceivedTimestamp = requestReceivedTimestamp;
        this.responseGeneratedTimestamp = responseGeneratedTimestamp;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.displayMessage = displayMessage;
    }

    public ResponseContext() {
    }

    /**
     * @return The interactionId
     */
    @JsonProperty("interactionId")
    public String getInteractionId() {
        return interactionId;
    }

    /**
     * @param interactionId The interactionId
     */
    @JsonProperty("interactionId")
    public void setInteractionId(String interactionId) {
        this.interactionId = interactionId;
    }

    /**
     * @return The requestId
     */
    @JsonProperty("requestId")
    public String getRequestId() {
        return requestId;
    }

    /**
     * @param requestId The requestId
     */
    @JsonProperty("requestId")
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * @return The requestReceivedTimestamp
     */
    @JsonProperty("requestReceivedTimestamp")
    public String getRequestReceivedTimestamp() {
        return requestReceivedTimestamp;
    }

    /**
     * @param requestReceivedTimestamp The requestReceivedTimestamp
     */
    @JsonProperty("requestReceivedTimestamp")
    public void setRequestReceivedTimestamp(
            String requestReceivedTimestamp) {
        this.requestReceivedTimestamp = requestReceivedTimestamp;
    }

    /**
     * @return The responseGeneratedTimestamp
     */
    @JsonProperty("responseGeneratedTimestamp")
    public String getResponseGeneratedTimestamp() {
        return responseGeneratedTimestamp;
    }

    /**
     * @param responseGeneratedTimestamp The responseGeneratedTimestamp
     */
    @JsonProperty("responseGeneratedTimestamp")
    public void setResponseGeneratedTimestamp(
            String responseGeneratedTimestamp) {
        this.responseGeneratedTimestamp = responseGeneratedTimestamp;
    }

    /**
     * @return The statusCode
     */
    @JsonProperty("statusCode")
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode The statusCode
     */
    @JsonProperty("statusCode")
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return The statusMessage
     */
    @JsonProperty("statusMessage")
    public Object getStatusMessage() {
        return statusMessage;
    }

    /**
     * @param statusMessage The statusMessage
     */
    @JsonProperty("statusMessage")
    public void setStatusMessage(Object statusMessage) {
        this.statusMessage = statusMessage;
    }

    /**
     * @return The displayMessage
     */
    @JsonProperty("displayMessage")
    public Object getDisplayMessage() {
        return displayMessage;
    }

    /**
     * @param displayMessage The displayMessage
     */
    @JsonProperty("displayMessage")
    public void setDisplayMessage(Object displayMessage) {
        this.displayMessage = displayMessage;
    }

    @Override
    public String toString() {
        return "ResponseContext{" +
                "interactionId='" + interactionId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", requestReceivedTimestamp='" + requestReceivedTimestamp + '\'' +
                ", responseGeneratedTimestamp='" + responseGeneratedTimestamp + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", statusMessage=" + statusMessage +
                ", displayMessage=" + displayMessage +
                '}';
    }
}
