package transport;

public class WrongDriverException extends RuntimeException{
    public WrongDriverException(String message) {
        super(message);
    }
}