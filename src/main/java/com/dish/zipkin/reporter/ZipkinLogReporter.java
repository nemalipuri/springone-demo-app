package com.dish.zipkin.reporter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import zipkin.Span;
import zipkin.internal.JsonCodec;

public class ZipkinLogReporter implements ZipkinSpanReporter {

    public static final String ZIPKIN_HEADER = "BEGIN-ZIPKIN-SPAN_JSON";
    public static final String ZIPKIN_FOOTER = "END-ZIPKIN-SPAN_JSON";
    private static final Logger LOG = LoggerFactory.getLogger(ZipkinLogReporter.class);

    @Override
    public void report(Span span) {
        LOG.info(String.format("%s [%s] %s", ZIPKIN_HEADER, JsonCodec.SPAN_ADAPTER.toJson(span), ZIPKIN_FOOTER));
    }

}
