package piratesproject.models;

import piratesproject.enums.RequestTypesEnum;

public class RequestModel {

    private RequestTypesEnum type;
    private String jsonData;

    public RequestModel() {
    }

    public RequestModel(RequestTypesEnum type, String jsonData) {
        this.type = type;
        this.jsonData = jsonData;
    }

    public RequestTypesEnum getType() {
        return type;
    }

    public void setType(RequestTypesEnum type) {
        this.type = type;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
    
    
    
    
}
