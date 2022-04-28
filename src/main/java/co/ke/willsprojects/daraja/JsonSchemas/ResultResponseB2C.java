package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultResponseB2C {

    @JsonProperty("Result")
    private Result result;

    public Result getResult() {
        return result;
    }
}