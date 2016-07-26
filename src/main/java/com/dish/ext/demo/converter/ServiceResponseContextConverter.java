package com.dish.ext.demo.converter;

import com.dish.schema.common.servicecontext._2016_08_01.ServiceRequestContextType;
import com.dish.schema.common.servicecontext._2016_08_01.ServiceResponseContextType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
@Slf4j
public class ServiceResponseContextConverter {
    public ServiceResponseContextType getOutputContext(Date requestReceived,
                                                       ServiceRequestContextType requestContext, String statusCode, String statusMes,
                                                       String displayMes) throws UnknownHostException {
        Date responseCreated = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS z");
        TimeZone zone = TimeZone.getTimeZone("America/Denver");
        df1.setTimeZone(zone);

        ServiceResponseContextType responseContext = new ServiceResponseContextType();
        responseContext.setRequestReceivedTimestamp(df1.format(requestReceived));
        responseContext.setResponseGeneratedTimestamp(df1.format(new Date()));
        responseContext.setServerHostPort((InetAddress.getLocalHost()).getHostName());
        responseContext.setServiceDuration(responseCreated.getTime() - requestReceived.getTime());
        if (requestContext != null && null != requestContext.getServiceInteraction()) {
            if (null != requestContext.getServiceInteraction().getInteractionId()) {
                responseContext.setInteractionId(
                        requestContext.getServiceInteraction().getInteractionId());
            }

            if (null != requestContext.getServiceInteraction().getRequestId()) {
                responseContext.setRequestId(requestContext.getServiceInteraction().getRequestId());
            }

        }
        responseContext.setDisplayMessage(displayMes);
        responseContext.setStatusCode(statusCode);
        responseContext.setStatusMessage(statusMes);
        return responseContext;
    }
}
