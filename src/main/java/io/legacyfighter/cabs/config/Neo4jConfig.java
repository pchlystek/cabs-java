package io.legacyfighter.cabs.config;

import io.legacyfighter.cabs.transitanalyzer.GraphTransitAnalyzer;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class Neo4jConfig {

    @Value("${neo4j.db.file:testPath}")
    private String dbPath;

    @Bean(destroyMethod = "onClose")
    GraphTransitAnalyzer graphTransitAnalyzer()  {
        return new GraphTransitAnalyzer(notConnectedOnProdYet(dbPath));
    }

    @Bean
    GraphDatabaseService notConnectedOnProdYet(String dbPath) {
        return null;
    }


}

