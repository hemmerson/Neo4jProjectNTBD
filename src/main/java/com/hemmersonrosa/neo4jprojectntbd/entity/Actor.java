package com.hemmersonrosa.neo4jprojectntbd.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Node
public class Actor {

    @Id
    @GeneratedValue
    private Long id;
    private Long actor_id;
    private String first_name;
    private String last_name;
    private String last_update = formatarData(LocalDateTime.now());

    private String formatarData(LocalDateTime dateTime){
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(FORMATTER);
    }
}
