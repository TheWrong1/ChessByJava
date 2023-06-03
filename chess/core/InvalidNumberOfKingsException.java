package chess.core;

public class InvalidNumberOfKingsException extends IllegalArrangementException {
    public InvalidNumberOfKingsException(String message) {
        super(message);
    }
    public InvalidNumberOfKingsException() {
        super("The number of Kings is invalid");
    }
}
