package com.dish.ext.demo.model.rest;

public class ResponseContextBuilder {
    private String interactionId;

    private String requestId;

    private String requestReceivedTimestamp;

    private String responseGeneratedTimestamp;

    private String statusCode;

    private String statusMessage;

    private String displayMessage;

    public static ResponseContextBuilder responseContextBuilder() {
        return new ResponseContextBuilder();
    }

    public ResponseContextBuilder interactionId(String interactionId) {
        this.interactionId = interactionId;
        return this;
    }

    public ResponseContextBuilder requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public ResponseContextBuilder requestReceivedTimestamp(String requestReceivedTimestamp) {
        this.requestReceivedTimestamp = requestReceivedTimestamp;
        return this;
    }

    public ResponseContextBuilder responseGeneratedTimestamp(String responseGeneratedTimestamp) {
        this.responseGeneratedTimestamp = responseGeneratedTimestamp;
        return this;
    }

    public ResponseContextBuilder statusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public ResponseContextBuilder statusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
        return this;
    }

    public ResponseContextBuilder displayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
        return this;
    }

    public ResponseContext build() {
        return new ResponseContext(interactionId, requestId, requestReceivedTimestamp,
                responseGeneratedTimestamp, statusCode, statusMessage, displayMessage);
    }
}
