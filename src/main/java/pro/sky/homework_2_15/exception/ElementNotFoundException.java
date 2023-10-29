package pro.sky.homework_2_15.exception;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException(String message){
        super(message);
    }
}
