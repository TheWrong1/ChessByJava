package chess.core;

public class IllegalArrangementException extends Exception {
    public IllegalArrangementException(String message) {
        super(message);
    }

    public IllegalArrangementException() {
        super("Illegal Arrangement Exception");
    }

}
