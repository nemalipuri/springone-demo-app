package com.dish.ext.demo.model.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"interactionId", "requestId", "interactionProcessName", "interactionStep",
        "customerFacingTool", "acquisitionChannel", "agentId", "agentIdType", "oeNumber",
        "sellerName", "clientAppHost", "clientAppTimestamp"})
public class RequestContext {

    @JsonProperty("interactionId")
    private String interactionId;

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("interactionProcessName")
    private Object interactionProcessName;

    @JsonProperty("interactionStep")
    private Object interactionStep;

    @JsonProperty("customerFacingTool")
    private String customerFacingTool;

    @JsonProperty("acquisitionChannel")
    private String acquisitionChannel;

    @JsonProperty("agentId")
    private Object agentId;

    @JsonProperty("agentIdType")
    private Object agentIdType;

    @JsonProperty("oeNumber")
    private Object oeNumber;

    @JsonProperty("sellerName")
    private Object sellerName;

    @JsonProperty("clientAppHost")
    private Object clientAppHost;

    @JsonProperty("clientAppTimestamp")
    private String clientAppTimestamp;

    public RequestContext() {
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
     * @return The interactionProcessName
     */
    @JsonProperty("interactionProcessName")
    public Object getInteractionProcessName() {
        return interactionProcessName;
    }

    /**
     * @param interactionProcessName The interactionProcessName
     */
    @JsonProperty("interactionProcessName")
    public void setInteractionProcessName(
            Object interactionProcessName) {
        this.interactionProcessName = interactionProcessName;
    }

    /**
     * @return The interactionStep
     */
    @JsonProperty("interactionStep")
    public Object getInteractionStep() {
        return interactionStep;
    }

    /**
     * @param interactionStep The interactionStep
     */
    @JsonProperty("interactionStep")
    public void setInteractionStep(Object interactionStep) {
        this.interactionStep = interactionStep;
    }

    /**
     * @return The customerFacingTool
     */
    @JsonProperty("customerFacingTool")
    public String getCustomerFacingTool() {
        return customerFacingTool;
    }

    /**
     * @param customerFacingTool The customerFacingTool
     */
    @JsonProperty("customerFacingTool")
    public void setCustomerFacingTool(
            String customerFacingTool) {
        this.customerFacingTool = customerFacingTool;
    }

    /**
     * @return The acquisitionChannel
     */
    @JsonProperty("acquisitionChannel")
    public String getAcquisitionChannel() {
        return acquisitionChannel;
    }

    /**
     * @param acquisitionChannel The acquisitionChannel
     */
    @JsonProperty("acquisitionChannel")
    public void setAcquisitionChannel(
            String acquisitionChannel) {
        this.acquisitionChannel = acquisitionChannel;
    }

    /**
     * @return The agentId
     */
    @JsonProperty("agentId")
    public Object getAgentId() {
        return agentId;
    }

    /**
     * @param agentId The agentId
     */
    @JsonProperty("agentId")
    public void setAgentId(Object agentId) {
        this.agentId = agentId;
    }

    /**
     * @return The agentIdType
     */
    @JsonProperty("agentIdType")
    public Object getAgentIdType() {
        return agentIdType;
    }

    /**
     * @param agentIdType The agentIdType
     */
    @JsonProperty("agentIdType")
    public void setAgentIdType(Object agentIdType) {
        this.agentIdType = agentIdType;
    }

    /**
     * @return The oeNumber
     */
    @JsonProperty("oeNumber")
    public Object getOeNumber() {
        return oeNumber;
    }

    /**
     * @param oeNumber The oeNumber
     */
    @JsonProperty("oeNumber")
    public void setOeNumber(Object oeNumber) {
        this.oeNumber = oeNumber;
    }

    /**
     * @return The sellerName
     */
    @JsonProperty("sellerName")
    public Object getSellerName() {
        return sellerName;
    }

    /**
     * @param sellerName The sellerName
     */
    @JsonProperty("sellerName")
    public void setSellerName(Object sellerName) {
        this.sellerName = sellerName;
    }

    /**
     * @return The clientAppHost
     */
    @JsonProperty("clientAppHost")
    public Object getClientAppHost() {
        return clientAppHost;
    }

    /**
     * @param clientAppHost The clientAppHost
     */
    @JsonProperty("clientAppHost")
    public void setClientAppHost(Object clientAppHost) {
        this.clientAppHost = clientAppHost;
    }

    /**
     * @return The clientAppTimestamp
     */
    @JsonProperty("clientAppTimestamp")
    public String getClientAppTimestamp() {
        return clientAppTimestamp;
    }

    /**
     * @param clientAppTimestamp The clientAppTimestamp
     */
    @JsonProperty("clientAppTimestamp")
    public void setClientAppTimestamp(
            String clientAppTimestamp) {
        this.clientAppTimestamp = clientAppTimestamp;
    }

    @Override
    public String toString() {
        return "RequestContext{" +
                "interactionId='" + interactionId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", interactionProcessName=" + interactionProcessName +
                ", interactionStep=" + interactionStep +
                ", customerFacingTool='" + customerFacingTool + '\'' +
                ", acquisitionChannel='" + acquisitionChannel + '\'' +
                ", agentId=" + agentId +
                ", agentIdType=" + agentIdType +
                ", oeNumber=" + oeNumber +
                ", sellerName=" + sellerName +
                ", clientAppHost=" + clientAppHost +
                ", clientAppTimestamp='" + clientAppTimestamp + '\'' +
                '}';
    }
}
