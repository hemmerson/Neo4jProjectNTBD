package com.hemmersonrosa.neo4jprojectntbd.repository;

import com.hemmersonrosa.neo4jprojectntbd.entity.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ActorRepository extends Neo4jRepository<Actor, Long> {
}
