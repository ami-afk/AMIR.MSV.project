package MESSANGER.EXCEPTIONS.Errors;

import MESSANGER.EXCEPTIONS.MessangerErrorType;
import MESSANGER.EXCEPTIONS.MessangerException;

public class FileOpException extends MessangerException {

    public FileOpException() {
        super(MessangerErrorType.FILE_OPErARION_FAILED);
    }
}
