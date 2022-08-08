package africa.semicolon.blogProject.exceptions;

public class UserLoggedInException extends RuntimeException{
    public UserLoggedInException(){
        super();
    }
    public  UserLoggedInException(String message){
        super(message);
    }
    public  UserLoggedInException(String message, Throwable cause){
        super(message,cause);
    }
    public  UserLoggedInException(Throwable cause){
        super(cause);
    }
}
