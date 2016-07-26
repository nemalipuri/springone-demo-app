package com.dish.ext.demo.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class SystemTimeSource implements TimeSource {

    @Override
    public LocalDateTime now(ZoneId zoneId) {
        return LocalDateTime.now(zoneId);
    }

}