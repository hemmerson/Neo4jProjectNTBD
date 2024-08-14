package com.hemmersonrosa.neo4jprojectntbd.entity;

import com.hemmersonrosa.neo4jprojectntbd.utils.StringToLocalDateTimeConverter;
import jakarta.persistence.Convert;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Node
public class Language {

    @Id
    @GeneratedValue
    private Long id;
    private Long language_id;
    private String name;
    private String last_update = formatarData(LocalDateTime.now());

    private String formatarData(LocalDateTime dateTime){
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(FORMATTER);
    }
}
