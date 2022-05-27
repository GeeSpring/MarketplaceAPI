package com.geespring.marketapi.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeUtil {

    /**
     * Gets the current local date and time
     * @return the timestamp
     */
    public String getLocalDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
