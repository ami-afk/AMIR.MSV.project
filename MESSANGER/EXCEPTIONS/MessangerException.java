package MESSANGER.EXCEPTIONS;

public class MessangerException extends RuntimeException{

    private final MessangerErrorType errorType;


    public MessangerException(MessangerErrorType errorType) {
        this.errorType = errorType;
    }

    public MessangerErrorType getErrorType() {
        return errorType;
    }
}
