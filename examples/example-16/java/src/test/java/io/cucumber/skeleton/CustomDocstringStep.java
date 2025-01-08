package io.cucumber.skeleton;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;
import io.cucumber.java.en.Given;

public class CustomDocstringStep {
    private static ObjectMapper objectMapper = new ObjectMapper();

    @DocStringType
    public JsonNode json(String text) throws JsonProcessingException {
        return objectMapper.readValue(text, JsonNode.class);
    }

    @Given("the following JSON data is entered:")
    public void the_following_json_data_is_entered(JsonNode books) {
        // step code goes here...
    }
}