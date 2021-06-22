package app.lifeni.bms.entity.message;

public class BaseMessage {
    private String message;

    public BaseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
