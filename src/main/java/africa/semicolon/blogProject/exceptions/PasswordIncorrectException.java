package africa.semicolon.blogProject.exceptions;

public class PasswordIncorrectException extends RuntimeException{
    public PasswordIncorrectException(){
        super();
    }
    public  PasswordIncorrectException(String message){
        super(message);
    }
    public PasswordIncorrectException(String message,Throwable c){
        super(message,c);
    }
    public PasswordIncorrectException(Throwable c){
        super(c);
    }
}
