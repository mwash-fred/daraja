package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReferenceData {

    @JsonProperty("ReferenceItem")
    private ReferenceItem referenceItem;

    public ReferenceItem getReferenceItem() {
        return referenceItem;
    }
}