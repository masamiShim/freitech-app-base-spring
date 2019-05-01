package com.genius.solar.freitech.db.elasticsearch.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class ElectricEnergyIndexRepository {
    private RestHighLevelClient client;
    private ObjectMapper mapper;

    @Autowired
    public ElectricEnergyIndexRepository(RestHighLevelClient client, ObjectMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    public void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("energy");
        // Indexの設定
        request.settings(
                Settings.builder()
                        .put("index.number_of_shards", 3)
                        .put("index.number_of_replicas", 3));
        // Indexの構造
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject()
                .startObject("properties");
        builder.startObject("recordDate")
                .field("type", "date")
                .field("format", "yyyy-MM-dd")
                .endObject();
        builder.startObject("total")
                .field("type", "float")
                .endObject();
        builder.startObject("max")
                .field("type", "long")
                .endObject();
        builder.startObject("min")
                .field("type", "long")
                .endObject();
        builder.startObject("ave")
                .field("type", "float")
                .endObject();
        builder.endObject()
                .endObject();
        request.mapping(builder);
        CreateIndexResponse indexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        if(!indexResponse.isAcknowledged()){
            throw new RuntimeException("Index作成に失敗");
        }
    }
}
