package exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String name){
        super("Invalid name: " + name);
    }
}
