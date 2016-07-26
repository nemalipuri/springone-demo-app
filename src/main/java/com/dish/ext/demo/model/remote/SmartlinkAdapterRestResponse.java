package com.dish.ext.demo.model.remote;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = true)
public class SmartlinkAdapterRestResponse {

    private ResponseContext responseContext = new ResponseContext();

    private String returnCode;
    private String returnMessage;
    private String adapterXmlReply;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((responseContext == null) ? 0 : responseContext.hashCode());
        result = prime * result + ((returnCode == null) ? 0 : returnCode.hashCode());
        result = prime * result + ((returnMessage == null) ? 0 : returnMessage.hashCode());
        result = prime * result + ((adapterXmlReply == null) ? 0 : adapterXmlReply.hashCode());
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
        SmartlinkAdapterRestResponse other = (SmartlinkAdapterRestResponse) obj;
        if (responseContext == null) {
            if (other.responseContext != null)
                return false;
        } else if (!responseContext.equals(other.responseContext))
            return false;
        if (returnCode == null) {
            if (other.returnCode != null)
                return false;
        } else if (!returnCode.equals(other.returnCode))
            return false;
        if (returnMessage == null) {
            if (other.returnMessage != null)
                return false;
        } else if (!returnMessage.equals(other.returnMessage))
            return false;
        if (adapterXmlReply == null) {
            if (other.adapterXmlReply != null)
                return false;
        } else if (!adapterXmlReply.equals(other.adapterXmlReply))
            return false;
        return true;
    }

}
