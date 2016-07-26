package com.dish.ext.demo.model.remote;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "returnCode",
        "message"
})
@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(name = "ReturnCode", required = true)
    protected BigInteger returnCode;
    @XmlElement(name = "Message")
    protected List<String> message;

    /**
     * Gets the value of the returnCode property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getReturnCode() {
        return returnCode;
    }

    /**
     * Sets the value of the returnCode property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setReturnCode(BigInteger value) {
        this.returnCode = value;
    }

    /**
     * Gets the value of the message property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the message property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessage().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getMessage() {
        if (message == null) {
            message = new ArrayList<String>();
        }
        return this.message;
    }

}
