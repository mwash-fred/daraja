package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultParameterItem {

    @JsonProperty("Value")
    private int value;

    @JsonProperty("Key")
    private String key;

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}