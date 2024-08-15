package com.hemmersonrosa.neo4jprojectntbd.utils;

import org.neo4j.driver.Value;
import org.neo4j.driver.Values;
import org.springframework.data.neo4j.core.convert.Neo4jPersistentPropertyConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class StringToLocalDateTimeConverter implements Neo4jPersistentPropertyConverter<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public Value write(LocalDateTime source) {
        return source != null ? Values.value(source.format(FORMATTER)) : null;
    }

    @Override
    public LocalDateTime read(Value source) {
        return LocalDateTime.parse(source.asString(), FORMATTER);
    }
}
