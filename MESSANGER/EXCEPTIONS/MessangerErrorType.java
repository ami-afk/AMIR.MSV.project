package MESSANGER.EXCEPTIONS;

public enum MessangerErrorType {

    FILE_OPErARION_FAILED ( 129, "Error in saving Files"),
    NOT_FOUND(455, "NOT FOUND"),
    ALREADY_EXISTS(505, "Sme Record"),
    AUTHENTICATION_FAILED(420,"uSENAME OR PASSWORD IS WRONG")
    ;
    private final int Code ;
    private final String Description;

    MessangerErrorType(int code, String description) {
        Code = code;
        Description = description;
    }

    public int getCode() {
        return Code;
    }

    public String getDescription() {
        return Description;
    }
}
