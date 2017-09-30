package com.panes.dozerprotobuf;

import com.google.protobuf.Timestamp;
import org.dozer.CustomConverter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

@Component
public class DateConverter implements CustomConverter {

    public DateConverter() {
    }

    @Override
    public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
        return fromLocalDate((LocalDate) sourceFieldValue);
    }

    private Timestamp fromLocalDate(LocalDate localDate) {
        if(localDate == null) return null;

        Instant instant = localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
        return Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }
}

