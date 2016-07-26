package com.dish.ext.demo.model.rest;

public class DemoServiceRequest {

    private RequestContext requestContext;

    public DemoServiceRequest() {
    }

    public DemoServiceRequest(RequestContext requestContext, String zipcode) {
        this.requestContext = requestContext;
    }

    public RequestContext getRequestContext() {
        return requestContext;
    }

    public void setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public String toString() {
        return "DemoServiceRequest{" +
                "requestContext=" + requestContext +
                '}';
    }
}
