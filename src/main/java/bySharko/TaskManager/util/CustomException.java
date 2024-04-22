package bySharko.TaskManager.util;

public class CustomException extends RuntimeException{
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public CustomException(String message) {
        this.message = message;
    }


}
