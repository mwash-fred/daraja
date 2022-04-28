package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultParameters {

    @JsonProperty("ResultParameter")
    private List<ResultParameterItem> resultParameter;

    public List<ResultParameterItem> getResultParameter() {
        return resultParameter;
    }
}