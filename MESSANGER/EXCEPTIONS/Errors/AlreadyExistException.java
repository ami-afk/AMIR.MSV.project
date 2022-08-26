package MESSANGER.EXCEPTIONS.Errors;

import MESSANGER.EXCEPTIONS.MessangerErrorType;
import MESSANGER.EXCEPTIONS.MessangerException;

public class AlreadyExistException extends MessangerException {
    public AlreadyExistException() {
        super(MessangerErrorType.ALREADY_EXISTS);
    }



    }

