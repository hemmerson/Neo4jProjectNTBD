package com.hemmersonrosa.neo4jprojectntbd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Node
public class Film {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private Long film_id;
    private String special_features;
    private Long rental_duration;
    private Double rental_rate;
    private Long release_year;
    private Long length;
    private Double replacement_cost;
    private String rating;
    private String description;
    private String title;
    private String fulltext;
    private String last_update = formatarData(LocalDateTime.now());

    private String formatarData(LocalDateTime dateTime){
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(FORMATTER);
    }
}
