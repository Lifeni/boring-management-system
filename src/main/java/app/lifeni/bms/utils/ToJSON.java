package app.lifeni.bms.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ToJSON {
    public JsonNode t(Object object) {
        return new ObjectMapper().valueToTree(object);
    }
}
