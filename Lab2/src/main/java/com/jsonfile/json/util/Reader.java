package com.jsonfile.json.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsonfile.json.entities.SampleEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by schiduvasile on 5/9/17.
 */
public class Reader {

    private List<SampleEntity> list;

    public void jsonParser() {
        try {

            byte[] jsonData = Files.readAllBytes(Paths.get(System.getProperty("user.dir") +
                    "/src/main/resources/data.json"));

            ObjectMapper objectMapper = new ObjectMapper();

            list = objectMapper.readValue(jsonData, new TypeReference<List<SampleEntity>>() {});


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<SampleEntity> getList() {
        return list;
    }
}
