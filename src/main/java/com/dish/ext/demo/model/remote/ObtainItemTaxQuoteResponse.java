package com.dish.ext.demo.model.remote;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "response",
        "business",
        "account",
        "location",
        "taxQuote",
        "itemList"
})
@XmlRootElement(name = "ObtainItemTaxQuoteResponse")
public class ObtainItemTaxQuoteResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlElement(name = "Business")
    protected ObtainItemTaxQuoteResponse.Business business;
    @XmlElement(name = "Account")
    protected ObtainItemTaxQuoteResponse.Account account;
    @XmlElement(name = "Location")
    protected ObtainItemTaxQuoteResponse.Location location;
    @XmlElement(name = "TaxQuote")
    protected BigDecimal taxQuote;
    @XmlElement(name = "ItemList")
    protected ObtainItemTaxQuoteResponse.ItemList itemList;

    /**
     * Gets the value of the response property.
     *
     * @return possible object is
     * {@link Response }
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value allowed object is
     *              {@link Response }
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the business property.
     *
     * @return possible object is
     * {@link ObtainItemTaxQuoteResponse.Business }
     */
    public ObtainItemTaxQuoteResponse.Business getBusiness() {
        return business;
    }

    /**
     * Sets the value of the business property.
     *
     * @param value allowed object is
     *              {@link ObtainItemTaxQuoteResponse.Business }
     */
    public void setBusiness(ObtainItemTaxQuoteResponse.Business value) {
        this.business = value;
    }

    /**
     * Gets the value of the account property.
     *
     * @return possible object is
     * {@link ObtainItemTaxQuoteResponse.Account }
     */
    public ObtainItemTaxQuoteResponse.Account getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     *
     * @param value allowed object is
     *              {@link ObtainItemTaxQuoteResponse.Account }
     */
    public void setAccount(ObtainItemTaxQuoteResponse.Account value) {
        this.account = value;
    }

    /**
     * Gets the value of the location property.
     *
     * @return possible object is
     * {@link ObtainItemTaxQuoteResponse.Location }
     */
    public ObtainItemTaxQuoteResponse.Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value allowed object is
     *              {@link ObtainItemTaxQuoteResponse.Location }
     */
    public void setLocation(ObtainItemTaxQuoteResponse.Location value) {
        this.location = value;
    }

    /**
     * Gets the value of the taxQuote property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getTaxQuote() {
        return taxQuote;
    }

    /**
     * Sets the value of the taxQuote property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTaxQuote(BigDecimal value) {
        this.taxQuote = value;
    }

    /**
     * Gets the value of the itemList property.
     *
     * @return possible object is
     * {@link ObtainItemTaxQuoteResponse.ItemList }
     */
    public ObtainItemTaxQuoteResponse.ItemList getItemList() {
        return itemList;
    }

    /**
     * Sets the value of the itemList property.
     *
     * @param value allowed object is
     *              {@link ObtainItemTaxQuoteResponse.ItemList }
     */
    public void setItemList(ObtainItemTaxQuoteResponse.ItemList value) {
        this.itemList = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{}TaxTypeIndicator"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "taxTypeIndicator"
    })
    public static class Account {

        @XmlElement(name = "TaxTypeIndicator", required = true)
        protected String taxTypeIndicator;

        /**
         * Gets the value of the taxTypeIndicator property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getTaxTypeIndicator() {
            return taxTypeIndicator;
        }

        /**
         * Sets the value of the taxTypeIndicator property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setTaxTypeIndicator(String value) {
            this.taxTypeIndicator = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * <p>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{}BusinessUnit"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "businessUnit"
    })
    public static class Business {

        @XmlElement(name = "BusinessUnit", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger businessUnit;

        /**
         * Gets the value of the businessUnit property.
         *
         * @return possible object is
         * {@link BigInteger }
         */
        public BigInteger getBusinessUnit() {
            return businessUnit;
        }

        /**
         * Sets the value of the businessUnit property.
         *
         * @param value allowed object is
         *              {@link BigInteger }
         */
        public void setBusinessUnit(BigInteger value) {
            this.businessUnit = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * <p>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{}Count"/>
     *         &lt;element name="Item" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{}Code"/>
     *                   &lt;element name="Billing">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element ref="{}Charge"/>
     *                             &lt;element ref="{}TaxGroup"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "count",
            "item"
    })
    public static class ItemList {

        @XmlElement(name = "Count", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger count;
        @XmlElement(name = "Item", required = true)
        protected List<ObtainItemTaxQuoteResponse.ItemList.Item> item;

        /**
         * Gets the value of the count property.
         *
         * @return possible object is
         * {@link BigInteger }
         */
        public BigInteger getCount() {
            return count;
        }

        /**
         * Sets the value of the count property.
         *
         * @param value allowed object is
         *              {@link BigInteger }
         */
        public void setCount(BigInteger value) {
            this.count = value;
        }

        /**
         * Gets the value of the item property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObtainItemTaxQuoteResponse.ItemList.Item }
         */
        public List<ObtainItemTaxQuoteResponse.ItemList.Item> getItem() {
            if (item == null) {
                item = new ArrayList<ObtainItemTaxQuoteResponse.ItemList.Item>();
            }
            return this.item;
        }


        /**
         * <p>Java class for anonymous complex type.
         * <p>
         * <p>The following schema fragment specifies the expected content contained within this class.
         * <p>
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element ref="{}Code"/>
         *         &lt;element name="Billing">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element ref="{}Charge"/>
         *                   &lt;element ref="{}TaxGroup"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "code",
                "billing"
        })
        public static class Item {

            @XmlElement(name = "Code", required = true)
            protected String code;
            @XmlElement(name = "Billing", required = true)
            protected ObtainItemTaxQuoteResponse.ItemList.Item.Billing billing;

            /**
             * Gets the value of the code property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getCode() {
                return code;
            }

            /**
             * Sets the value of the code property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setCode(String value) {
                this.code = value;
            }

            /**
             * Gets the value of the billing property.
             *
             * @return possible object is
             * {@link ObtainItemTaxQuoteResponse.ItemList.Item.Billing }
             */
            public ObtainItemTaxQuoteResponse.ItemList.Item.Billing getBilling() {
                return billing;
            }

            /**
             * Sets the value of the billing property.
             *
             * @param value allowed object is
             *              {@link ObtainItemTaxQuoteResponse.ItemList.Item.Billing }
             */
            public void setBilling(ObtainItemTaxQuoteResponse.ItemList.Item.Billing value) {
                this.billing = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * <p>
             * <p>The following schema fragment specifies the expected content contained within this class.
             * <p>
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element ref="{}Charge"/>
             *         &lt;element ref="{}TaxGroup"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "charge",
                    "taxGroup"
            })
            public static class Billing {

                @XmlElement(name = "Charge", required = true)
                protected BigDecimal charge;
                @XmlElement(name = "TaxGroup", required = true)
                protected String taxGroup;

                /**
                 * Gets the value of the charge property.
                 *
                 * @return possible object is
                 * {@link BigDecimal }
                 */
                public BigDecimal getCharge() {
                    return charge;
                }

                /**
                 * Sets the value of the charge property.
                 *
                 * @param value allowed object is
                 *              {@link BigDecimal }
                 */
                public void setCharge(BigDecimal value) {
                    this.charge = value;
                }

                /**
                 * Gets the value of the taxGroup property.
                 *
                 * @return possible object is
                 * {@link String }
                 */
                public String getTaxGroup() {
                    return taxGroup;
                }

                /**
                 * Sets the value of the taxGroup property.
                 *
                 * @param value allowed object is
                 *              {@link String }
                 */
                public void setTaxGroup(String value) {
                    this.taxGroup = value;
                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * <p>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Address" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{}City"/>
     *                   &lt;element ref="{}State"/>
     *                   &lt;element ref="{}PostalCode"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Geographical">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{}VertexCode"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "address",
            "geographical"
    })
    public static class Location {

        @XmlElement(name = "Address")
        protected ObtainItemTaxQuoteResponse.Location.Address address;
        @XmlElement(name = "Geographical", required = true)
        protected ObtainItemTaxQuoteResponse.Location.Geographical geographical;

        /**
         * Gets the value of the address property.
         *
         * @return possible object is
         * {@link ObtainItemTaxQuoteResponse.Location.Address }
         */
        public ObtainItemTaxQuoteResponse.Location.Address getAddress() {
            return address;
        }

        /**
         * Sets the value of the address property.
         *
         * @param value allowed object is
         *              {@link ObtainItemTaxQuoteResponse.Location.Address }
         */
        public void setAddress(ObtainItemTaxQuoteResponse.Location.Address value) {
            this.address = value;
        }

        /**
         * Gets the value of the geographical property.
         *
         * @return possible object is
         * {@link ObtainItemTaxQuoteResponse.Location.Geographical }
         */
        public ObtainItemTaxQuoteResponse.Location.Geographical getGeographical() {
            return geographical;
        }

        /**
         * Sets the value of the geographical property.
         *
         * @param value allowed object is
         *              {@link ObtainItemTaxQuoteResponse.Location.Geographical }
         */
        public void setGeographical(ObtainItemTaxQuoteResponse.Location.Geographical value) {
            this.geographical = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * <p>
         * <p>The following schema fragment specifies the expected content contained within this class.
         * <p>
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element ref="{}City"/>
         *         &lt;element ref="{}State"/>
         *         &lt;element ref="{}PostalCode"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "city",
                "state",
                "postalCode"
        })
        public static class Address {

            @XmlElement(name = "City", required = true)
            protected String city;
            @XmlElement(name = "State", required = true)
            protected String state;
            @XmlElement(name = "PostalCode", required = true)
            protected String postalCode;

            /**
             * Gets the value of the city property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getCity() {
                return city;
            }

            /**
             * Sets the value of the city property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setCity(String value) {
                this.city = value;
            }

            /**
             * Gets the value of the state property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getState() {
                return state;
            }

            /**
             * Sets the value of the state property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setState(String value) {
                this.state = value;
            }

            /**
             * Gets the value of the postalCode property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getPostalCode() {
                return postalCode;
            }

            /**
             * Sets the value of the postalCode property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setPostalCode(String value) {
                this.postalCode = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * <p>
         * <p>The following schema fragment specifies the expected content contained within this class.
         * <p>
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element ref="{}VertexCode"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "vertexCode"
        })
        public static class Geographical {

            @XmlElement(name = "VertexCode", required = true)
            protected String vertexCode;

            /**
             * Gets the value of the vertexCode property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getVertexCode() {
                return vertexCode;
            }

            /**
             * Sets the value of the vertexCode property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setVertexCode(String value) {
                this.vertexCode = value;
            }

        }

    }

}
