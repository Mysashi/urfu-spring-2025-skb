package com.example.demo.service;


import com.example.demo.dto.GoodsJsonDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    private ObjectMapper objectMapper = new ObjectMapper();

    public GoodsJsonDto parseJson(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, GoodsJsonDto.class);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public String parsePojo(GoodsJsonDto goods) {
        try {
            return objectMapper.writeValueAsString(goods);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

}
