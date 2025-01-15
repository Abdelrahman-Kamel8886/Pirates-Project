package piratesproject.models;

import java.io.Serializable;
import piratesproject.enums.RequestTypesEnum;

public class ResponseModel implements Serializable {

    private int status;
    private String message;
    private String Data;
    private RequestTypesEnum type;

    public ResponseModel() {
    }

    @Override
    public String toString() {
        return "ResponseModel{" + "status=" + status + ", message=" + message + '}';
    }
    

    public ResponseModel(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseModel(int status, String message, String Data) {
        this.status = status;
        this.message = message;
        this.Data = Data;
    }

    public ResponseModel(int status, String message, String Data, RequestTypesEnum type) {
        this.status = status;
        this.message = message;
        this.Data = Data;
        this.type = type;
    }
    
    

    public RequestTypesEnum getType() {
        return type;
    }

    public void setType(RequestTypesEnum type) {
        this.type = type;
    }
    
    

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
    
    


    
    
}
