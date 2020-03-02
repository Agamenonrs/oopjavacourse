package exception;/*
@author Agamenon
*/

public class ContactException extends  Exception {

    private String message = "";

    public ContactException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
