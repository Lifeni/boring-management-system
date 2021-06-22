package app.lifeni.bms.entity.message;

public class DataMessage {
    private String message;
    private Object data;

    public DataMessage(String message, Object response) {
        this.message = message;
        this.data = response;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
