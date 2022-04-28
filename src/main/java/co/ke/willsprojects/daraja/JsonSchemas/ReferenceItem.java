package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReferenceItem {

    @JsonProperty("Value")
    private String value;

    @JsonProperty("Key")
    private String key;

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}