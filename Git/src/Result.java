package Resources;

public class Result {
    private String message;
    private boolean bool;
    Result(String mess, boolean b) {
        this.message = mess;
        this.bool = b;
    }
    public String getMessage() {
        return message;
    }
    public boolean isSuccessful() {
        return bool;
    }
}
