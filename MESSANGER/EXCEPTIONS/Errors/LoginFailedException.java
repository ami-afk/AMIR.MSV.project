package MESSANGER.EXCEPTIONS.Errors;

import MESSANGER.EXCEPTIONS.MessangerErrorType;
import MESSANGER.EXCEPTIONS.MessangerException;

public class LoginFailedException extends MessangerException {
    public LoginFailedException() {
        super(MessangerErrorType.AUTHENTICATION_FAILED);
    }



    }

