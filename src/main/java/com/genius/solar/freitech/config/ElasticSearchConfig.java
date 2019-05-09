package com.genius.solar.freitech.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
@ConditionalOnExpression("${application.setting.use.elasticsearch:} eq true")
public class ElasticSearchConfig {
    @Value("${elasticsearch.setting.host}")
    private String HOST;

    @Value("${elasticsearch.setting.port}")
    private int PORT;

    @Bean
    RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(HOST, PORT, "http")));
        return client;
    }

    @PreDestroy
    public void closeClient() throws IOException {
        restHighLevelClient().close();
    }
}
