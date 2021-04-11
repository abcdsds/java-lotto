package step4.exception;

public class IllegalLottoRangeException extends RuntimeException{
    public IllegalLottoRangeException() {
        super();
    }

    public IllegalLottoRangeException(String message) {
        super(message);
    }
}
