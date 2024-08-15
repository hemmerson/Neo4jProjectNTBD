package com.hemmersonrosa.neo4jprojectntbd;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;

public class Connection {
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("neo4j+s://a95fcb77.databases.neo4j.io", AuthTokens.basic("neo4j", "3V1O3A0Owyrb8VkBrS1zDShyY1wg8gwStEDJOp9Qcco"));
        try (Session session = driver.session()) {
            String greeting = session.writeTransaction(tx -> {
                var result = tx.run("RETURN 'Hello, Neo4j!' AS greeting");
                return result.single().get("greeting").asString();
            });
            System.out.println(greeting);
        } finally {
            driver.close();
        }
    }
}
