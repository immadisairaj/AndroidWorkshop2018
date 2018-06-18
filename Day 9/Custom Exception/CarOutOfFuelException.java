import java.io.IOException;

public class CarOutOfFuelException extends IOException {
    public CarOutOfFuelException(String customMessage) {
        super(customMessage);
    }
}