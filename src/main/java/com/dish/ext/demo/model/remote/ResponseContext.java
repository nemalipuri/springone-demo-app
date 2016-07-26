package com.dish.ext.demo.model.remote;

public class ResponseContext {
    private String interactionId;
    private String requestId;
    private String requestReceivedTimestamp;
    private String responseGeneratedTimestamp;
    private String statusCode;
    private String statusMessage;
    private String displayMessage;

    public ResponseContext() {
    }

    public ResponseContext(String interactionId, String requestId, String requestReceivedTimestamp, String responseGeneratedTimestamp, String statusCode, String statusMessage, String displayMessage) {
        this.interactionId = interactionId;
        this.requestId = requestId;
        this.requestReceivedTimestamp = requestReceivedTimestamp;
        this.responseGeneratedTimestamp = responseGeneratedTimestamp;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.displayMessage = displayMessage;
    }

    public String getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(String interactionId) {
        this.interactionId = interactionId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestReceivedTimestamp() {
        return requestReceivedTimestamp;
    }

    public void setRequestReceivedTimestamp(String requestReceivedTimestamp) {
        this.requestReceivedTimestamp = requestReceivedTimestamp;
    }

    public String getResponseGeneratedTimestamp() {
        return responseGeneratedTimestamp;
    }

    public void setResponseGeneratedTimestamp(String responseGeneratedTimestamp) {
        this.responseGeneratedTimestamp = responseGeneratedTimestamp;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((displayMessage == null) ? 0 : displayMessage.hashCode());
        result = prime * result + ((interactionId == null) ? 0 : interactionId.hashCode());
        result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
        result = prime * result + ((requestReceivedTimestamp == null) ? 0 : requestReceivedTimestamp.hashCode());
        result = prime * result + ((responseGeneratedTimestamp == null) ? 0 : responseGeneratedTimestamp.hashCode());
        result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
        result = prime * result + ((statusMessage == null) ? 0 : statusMessage.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResponseContext other = (ResponseContext) obj;
        if (displayMessage == null) {
            if (other.displayMessage != null)
                return false;
        } else if (!displayMessage.equals(other.displayMessage))
            return false;
        if (interactionId == null) {
            if (other.interactionId != null)
                return false;
        } else if (!interactionId.equals(other.interactionId))
            return false;
        if (requestId == null) {
            if (other.requestId != null)
                return false;
        } else if (!requestId.equals(other.requestId))
            return false;
        if (requestReceivedTimestamp == null) {
            if (other.requestReceivedTimestamp != null)
                return false;
        } else if (!requestReceivedTimestamp.equals(other.requestReceivedTimestamp))
            return false;
        if (responseGeneratedTimestamp == null) {
            if (other.responseGeneratedTimestamp != null)
                return false;
        } else if (!responseGeneratedTimestamp.equals(other.responseGeneratedTimestamp))
            return false;
        if (statusCode == null) {
            if (other.statusCode != null)
                return false;
        } else if (!statusCode.equals(other.statusCode))
            return false;
        if (statusMessage == null) {
            if (other.statusMessage != null)
                return false;
        } else if (!statusMessage.equals(other.statusMessage))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ResponseContext [interactionId=" + interactionId + ", requestId=" + requestId
                + ", requestReceivedTimestamp=" + requestReceivedTimestamp + ", responseGeneratedTimestamp="
                + responseGeneratedTimestamp + ", statusCode=" + statusCode + ", statusMessage=" + statusMessage
                + ", displayMessage=" + displayMessage + "]";
    }


}