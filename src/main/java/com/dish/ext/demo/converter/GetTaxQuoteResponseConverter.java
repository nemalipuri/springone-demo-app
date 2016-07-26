package com.dish.ext.demo.converter;

import com.dish.ext.demo.model.remote.ObtainItemTaxQuoteResponse;
import com.dish.ext.demo.model.remote.SmartlinkAdapterRestResponse;
import com.dish.ext.demo.util.AdapterDownConfig;
import com.dish.ext.demo.util.AdapterErrorConfig;
import com.dish.schema.common.servicecontext._2016_08_01.ServiceResponseContextType;
import com.dish.schema.demo.gettaxquote._2016_08_01.BillingType;
import com.dish.schema.demo.gettaxquote._2016_08_01.GetTaxQuoteOutputType;
import com.dish.schema.demo.gettaxquote._2016_08_01.ItemListType;
import com.dish.schema.demo.gettaxquote._2016_08_01.ItemType;
import com.dish.wsdl.demo.demo_v1.GetTaxQuoteResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

@Slf4j
@Component
public class GetTaxQuoteResponseConverter {

    private static JAXBContext jaxbContext;

    static {
        try {
            jaxbContext = JAXBContext.newInstance(ObtainItemTaxQuoteResponse.class);
            log.info("JaxbContext has been initialized");
        } catch (JAXBException je) {
            log.error("Unable to initialize jaxb. Exiting the application. ", je);
            System.exit(-1);
        }
    }

    @Autowired
    public AdapterErrorConfig adapterErrorConfig;
    @Autowired
    public AdapterDownConfig adapterDownConfig;
    @Value("${message.getTaxQuote.other.statusCode}")
    public String statusCode;
    @Value("${message.getTaxQuote.other.statusMessage}")
    public String statusMessage;
    @Value("${message.getTaxQuote.other.displayMessage}")
    public String displayMessage;

    public GetTaxQuoteResponse mapResponse(SmartlinkAdapterRestResponse response) throws Exception {
        GetTaxQuoteResponse getTaxQuoteResponse = new GetTaxQuoteResponse();
        ServiceResponseContextType responseContext = new ServiceResponseContextType();
        GetTaxQuoteOutputType getTaxQuoteOutputType = new GetTaxQuoteOutputType();
        ObtainItemTaxQuoteResponse obtainItemTaxQuoteResponse;

        if (response.getResponseContext() != null) {
            responseContext.setInteractionId(response.getResponseContext().getInteractionId());
            responseContext.setRequestId(response.getResponseContext().getRequestId());
            responseContext.setRequestReceivedTimestamp(
                    response.getResponseContext().getRequestReceivedTimestamp());
            responseContext.setResponseGeneratedTimestamp(
                    response.getResponseContext().getResponseGeneratedTimestamp());

            if (response.getReturnCode() != null && !"0"
                    .equalsIgnoreCase(response.getReturnCode())) {
                //Failure case
                List<String> keywordList1 = adapterErrorConfig.getKeyword();
                List<String> keywordList2 = adapterDownConfig.getKeyword();
                String returnMessage = response.getReturnMessage();

                boolean setFields = false;
                for (String keyword : keywordList1) {
                    if (keyword != null && returnMessage != null) {
                        if (returnMessage.toLowerCase().contains(keyword.toLowerCase())) {
                            responseContext.setStatusCode(adapterErrorConfig.getStatusCode());
                            responseContext.setStatusMessage(
                                    adapterErrorConfig.getStatusMessage() + " " + returnMessage);
                            responseContext.setDisplayMessage(adapterErrorConfig.getDisplayMessage());
                            setFields = true;
                        }
                    }
                }
                if (!setFields) {
                    for (String keyword : keywordList2) {
                        if (keyword != null && returnMessage != null) {
                            if (returnMessage.toLowerCase().contains(keyword.toLowerCase())) {
                                responseContext.setStatusCode(adapterDownConfig.getStatusCode());
                                responseContext.setStatusMessage(
                                        adapterDownConfig.getStatusMessage() + " " + returnMessage);
                                responseContext
                                        .setDisplayMessage(adapterDownConfig.getDisplayMessage());
                                setFields = true;
                            }
                        }
                    }
                }
                if (!setFields) {
                    responseContext.setStatusCode(statusCode);
                    responseContext.setStatusMessage(statusMessage);
                    responseContext.setDisplayMessage(displayMessage);
                }
            } else if (response.getResponseContext().getStatusCode() != null && !"0"
                    .equalsIgnoreCase(response.getResponseContext().getStatusCode())) {
                //Failure case
                responseContext.setStatusCode(statusCode);
                responseContext.setStatusMessage(statusMessage);
                responseContext.setDisplayMessage(displayMessage);
            } else {
                //success case
                responseContext.setStatusCode(response.getResponseContext().getStatusCode());
                responseContext.setStatusMessage(response.getResponseContext().getStatusMessage());
                responseContext
                        .setDisplayMessage(response.getResponseContext().getDisplayMessage());
            }
        }
        getTaxQuoteResponse.setServiceResponseContext(responseContext);

        if (responseContext.getStatusCode() != null && "0"
                .equalsIgnoreCase(responseContext.getStatusCode())) {
            // Get  obtainItemTaxQuoteResponse from AdapterXmlReply


            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(response.getAdapterXmlReply());
            obtainItemTaxQuoteResponse = (ObtainItemTaxQuoteResponse) unmarshaller.unmarshal(reader);

            if (obtainItemTaxQuoteResponse != null) {
                // Map obtainItemTaxQuoteResponse to getTaxQuoteOutput
                ItemListType itemListType = new ItemListType();

                if (obtainItemTaxQuoteResponse.getItemList() != null) {
                    for (ObtainItemTaxQuoteResponse.ItemList.Item l : obtainItemTaxQuoteResponse
                            .getItemList().getItem()) {
                        ItemType item = new ItemType();
                        BillingType billing = new BillingType();
                        billing.setCharge(null != l ?
                                (null != l.getBilling() ? (l.getBilling().getCharge()) : null) :
                                null);
                        billing.setTaxGroup(null != l ?
                                (null != l.getBilling() ? (l.getBilling().getTaxGroup()) : null) :
                                null);

                        item.setIdentifier(null != l ? (l.getCode()) : null);
                        item.setBilling(billing);

                        itemListType.getItem().add(item);
                    }
                    itemListType.setCount(obtainItemTaxQuoteResponse.getItemList().getCount());
                }
                getTaxQuoteOutputType.setItemList(itemListType);
                getTaxQuoteOutputType.setTaxQuote(obtainItemTaxQuoteResponse.getTaxQuote());
            }
        }

        getTaxQuoteResponse.setGetTaxQuoteOutput(getTaxQuoteOutputType);
        return getTaxQuoteResponse;
    }

    public GetTaxQuoteResponse mapResponseContext(String displayMessage, String statusMessage,
                                                  String statusCode) throws Exception {
        GetTaxQuoteResponse getTaxQuoteResponse = new GetTaxQuoteResponse();
        ServiceResponseContextType responseContext = new ServiceResponseContextType();
        responseContext.setStatusCode(statusCode);
        responseContext.setStatusMessage(statusMessage);
        responseContext.setDisplayMessage(displayMessage);
        getTaxQuoteResponse.setServiceResponseContext(responseContext);
        return getTaxQuoteResponse;
    }
}
