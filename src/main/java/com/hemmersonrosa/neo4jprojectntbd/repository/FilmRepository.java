package com.hemmersonrosa.neo4jprojectntbd.repository;

import com.hemmersonrosa.neo4jprojectntbd.entity.Language;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface LanguageRepository extends Neo4jRepository<Language, Long> {
}
