package com.dish.ext.demo.converter;

import com.dish.ext.demo.model.payload.Payload;
import com.dish.ext.demo.model.payload.RequestContext;
import com.dish.ext.demo.model.remote.ObtainItemTaxQuote;
import com.dish.schema.demo.gettaxquote._2016_08_01.ItemListType;
import com.dish.wsdl.demo.demo_v1.GetTaxQuoteRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

@Slf4j
@Component
public class GetTaxQuoteRequestConverter {
    private static JAXBContext jaxbContext;

    static {
        try {
            jaxbContext = JAXBContext.newInstance(ObtainItemTaxQuote.class);
            log.info("JaxbContext has been initialized");
        } catch (JAXBException je) {
            log.error("Unable to initialize jaxb. Exiting the application. ", je);
            System.exit(-1);
        }
    }

    public Payload mapRequest(GetTaxQuoteRequest request) throws Exception {
        Payload payload = new Payload();
        RequestContext requestContext = new RequestContext();

        requestContext.setInteractionId(null != request.getServiceRequestContext() ?
                (null != request.getServiceRequestContext().getServiceInteraction() ?
                        (null != request.getServiceRequestContext().getServiceInteraction()
                                .getInteractionId() ?
                                (request.getServiceRequestContext().getServiceInteraction()
                                        .getInteractionId()) :
                                null) :
                        null) :
                null);
        requestContext.setRequestId(null != request.getServiceRequestContext() ?
                (null != request.getServiceRequestContext().getServiceInteraction() ?
                        (null != request.getServiceRequestContext().getServiceInteraction()
                                .getRequestId() ?
                                (request.getServiceRequestContext().getServiceInteraction()
                                        .getRequestId()) :
                                null) :
                        null) :
                null);
        requestContext.setInteractionProcessName(null != request.getServiceRequestContext() ?
                (null != request.getServiceRequestContext().getServiceInteraction() ?
                        (null != request.getServiceRequestContext().getServiceInteraction()
                                .getInteractionProcessName() ?
                                (request.getServiceRequestContext().getServiceInteraction()
                                        .getInteractionProcessName()) :
                                null) :
                        null) :
                null);
        requestContext.setInteractionStep(null != request.getServiceRequestContext() ?
                (null != request.getServiceRequestContext().getServiceInteraction() ?
                        (null != request.getServiceRequestContext().getServiceInteraction()
                                .getInteractionStep() ?
                                (request.getServiceRequestContext().getServiceInteraction()
                                        .getInteractionStep()) :
                                null) :
                        null) :
                null);

        requestContext.setCustomerFacingTool(null != request.getServiceRequestContext() ?
                (null != request.getServiceRequestContext().getServiceInteraction() ?
                        (null != request.getServiceRequestContext().getServiceInteraction()
                                .getCustomerFacingTool() ?
                                (request.getServiceRequestContext().getServiceInteraction()
                                        .getCustomerFacingTool()) :
                                null) :
                        null) :
                null);

        requestContext.setClientAppHost(null != request.getServiceRequestContext() ?
                (null != request.getServiceRequestContext().getServiceClientDetails() ?
                        (request.getServiceRequestContext().getServiceClientDetails()
                                .getClientAppHost()) :
                        null) :
                null);

        // Map getTaxQuoteInput to ObtainItemTaxQuote POJO
        ObtainItemTaxQuote obtainItemTaxQuote = new ObtainItemTaxQuote();
        ObtainItemTaxQuote.Business business = new ObtainItemTaxQuote.Business();
        ObtainItemTaxQuote.Location location = new ObtainItemTaxQuote.Location();
        ObtainItemTaxQuote.ItemList itemList = new ObtainItemTaxQuote.ItemList();
        ObtainItemTaxQuote.Location.Geographical geographical = new ObtainItemTaxQuote.Location.Geographical();

        //Iterate through ItemListType from getTaxQuoteRequest and assign it to ObtainItemTaxQuote itemList
        ItemListType itemListType = (null != request.getGetTaxQuoteInput() ?
                (request.getGetTaxQuoteInput().getItemList()) :
                null);
        if (itemListType != null) {
            for (com.dish.schema.demo.gettaxquote._2016_08_01.ItemType l : itemListType
                    .getItem()) {
                ObtainItemTaxQuote.ItemList.Item item = new ObtainItemTaxQuote.ItemList.Item();
                ObtainItemTaxQuote.ItemList.Item.Billing billing = new ObtainItemTaxQuote.ItemList.Item.Billing();
                billing.setCharge(null != l ?
                        (null != l.getBilling() ?
                                (null != l.getBilling().getCharge() ?
                                        (l.getBilling().getCharge()) :
                                        (new BigDecimal("0"))) :
                                null) :
                        null);

                item.setCode(null != l ? (l.getIdentifier()) : null);
                item.setBilling(billing);

                itemList.getItem().add(item);
            }
        }

        business.setBusinessUnit(new BigInteger("804690009800"));

        geographical.setVertexCode(null != request.getGetTaxQuoteInput() ?
                (null != request.getGetTaxQuoteInput().getLocation() ?
                        (null != request.getGetTaxQuoteInput().getLocation().getGeographical() ?
                                (request.getGetTaxQuoteInput().getLocation().getGeographical()
                                        .getVertexCode()) :
                                null) :
                        null) :
                null);

        location.setGeographical(geographical);
        obtainItemTaxQuote.setBusiness(business);
        obtainItemTaxQuote.setLocation(location);
        obtainItemTaxQuote.setItemList(itemList);

        // Convert ObtainItemTaxQuote POJO to XML String
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        JAXBElement jaxbElement = new JAXBElement(new QName("ObtainItemTaxQuote"),
                ObtainItemTaxQuote.class, obtainItemTaxQuote);
        StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal(jaxbElement, sw);

        payload.setAdapterXmlRequest(sw.toString());
        payload.setRequestContext(requestContext);
        payload.setTransactionName("ObtainItemTaxQuote");
        return payload;
    }

}
