package com.hemmersonrosa.neo4jprojectntbd.repository;

import com.hemmersonrosa.neo4jprojectntbd.entity.Film;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FilmRepository extends Neo4jRepository<Film, Long> {
}
