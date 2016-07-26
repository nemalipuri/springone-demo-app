package com.dish.ext.demo.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public interface TimeSource {
    public LocalDateTime now(ZoneId zoneId);
}
