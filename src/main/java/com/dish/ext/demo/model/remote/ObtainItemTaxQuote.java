package com.dish.ext.demo.model.remote;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "business",
        "account",
        "location",
        "itemList"
})
@XmlRootElement(name = "ObtainItemTaxQuote")
public class ObtainItemTaxQuote {

    @XmlElement(name = "Business", required = true)
    protected ObtainItemTaxQuote.Business business;
    @XmlElement(name = "Account")
    protected ObtainItemTaxQuote.Account account;
    @XmlElement(name = "Location", required = true)
    protected ObtainItemTaxQuote.Location location;
    @XmlElement(name = "ItemList", required = true)
    protected ObtainItemTaxQuote.ItemList itemList;

    /**
     * Gets the value of the business property.
     *
     * @return possible object is
     * {@link ObtainItemTaxQuote.Business }
     */
    public ObtainItemTaxQuote.Business getBusiness() {
        return business;
    }

    /**
     * Sets the value of the business property.
     *
     * @param value allowed object is
     *              {@link ObtainItemTaxQuote.Business }
     */
    public void setBusiness(ObtainItemTaxQuote.Business value) {
        this.business = value;
    }

    /**
     * Gets the value of the account property.
     *
     * @return possible object is
     * {@link ObtainItemTaxQuote.Account }
     */
    public ObtainItemTaxQuote.Account getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     *
     * @param value allowed object is
     *              {@link ObtainItemTaxQuote.Account }
     */
    public void setAccount(ObtainItemTaxQuote.Account value) {
        this.account = value;
    }

    /**
     * Gets the value of the location property.
     *
     * @return possible object is
     * {@link ObtainItemTaxQuote.Location }
     */
    public ObtainItemTaxQuote.Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value allowed object is
     *              {@link ObtainItemTaxQuote.Location }
     */
    public void setLocation(ObtainItemTaxQuote.Location value) {
        this.location = value;
    }

    /**
     * Gets the value of the itemList property.
     *
     * @return possible object is
     * {@link ObtainItemTaxQuote.ItemList }
     */
    public ObtainItemTaxQuote.ItemList getItemList() {
        return itemList;
    }

    /**
     * Sets the value of the itemList property.
     *
     * @param value allowed object is
     *              {@link ObtainItemTaxQuote.ItemList }
     */
    public void setItemList(ObtainItemTaxQuote.ItemList value) {
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
            "item"
    })
    public static class ItemList {

        @XmlElement(name = "Item", required = true)
        protected List<ObtainItemTaxQuote.ItemList.Item> item;

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
         * {@link ObtainItemTaxQuote.ItemList.Item }
         */
        public List<ObtainItemTaxQuote.ItemList.Item> getItem() {
            if (item == null) {
                item = new ArrayList<ObtainItemTaxQuote.ItemList.Item>();
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
            protected ObtainItemTaxQuote.ItemList.Item.Billing billing;

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
             * {@link ObtainItemTaxQuote.ItemList.Item.Billing }
             */
            public ObtainItemTaxQuote.ItemList.Item.Billing getBilling() {
                return billing;
            }

            /**
             * Sets the value of the billing property.
             *
             * @param value allowed object is
             *              {@link ObtainItemTaxQuote.ItemList.Item.Billing }
             */
            public void setBilling(ObtainItemTaxQuote.ItemList.Item.Billing value) {
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
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "charge"
            })
            public static class Billing {

                @XmlElement(name = "Charge", required = true)
                protected BigDecimal charge;

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
     *       &lt;choice>
     *         &lt;element name="Address">
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
     *       &lt;/choice>
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
        protected ObtainItemTaxQuote.Location.Address address;
        @XmlElement(name = "Geographical")
        protected ObtainItemTaxQuote.Location.Geographical geographical;

        /**
         * Gets the value of the address property.
         *
         * @return possible object is
         * {@link ObtainItemTaxQuote.Location.Address }
         */
        public ObtainItemTaxQuote.Location.Address getAddress() {
            return address;
        }

        /**
         * Sets the value of the address property.
         *
         * @param value allowed object is
         *              {@link ObtainItemTaxQuote.Location.Address }
         */
        public void setAddress(ObtainItemTaxQuote.Location.Address value) {
            this.address = value;
        }

        /**
         * Gets the value of the geographical property.
         *
         * @return possible object is
         * {@link ObtainItemTaxQuote.Location.Geographical }
         */
        public ObtainItemTaxQuote.Location.Geographical getGeographical() {
            return geographical;
        }

        /**
         * Sets the value of the geographical property.
         *
         * @param value allowed object is
         *              {@link ObtainItemTaxQuote.Location.Geographical }
         */
        public void setGeographical(ObtainItemTaxQuote.Location.Geographical value) {
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
