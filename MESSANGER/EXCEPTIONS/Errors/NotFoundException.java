package MESSANGER.EXCEPTIONS.Errors;

import MESSANGER.EXCEPTIONS.MessangerErrorType;
import MESSANGER.EXCEPTIONS.MessangerException;

public class NotFoundException extends MessangerException {
    public NotFoundException() {
        super(MessangerErrorType.NOT_FOUND);
    }



    }

