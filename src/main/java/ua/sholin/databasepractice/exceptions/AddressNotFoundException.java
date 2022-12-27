package ua.sholin.databasepractice.exceptions;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(String message, Exception e) {
        super(message,e);
    }
}
