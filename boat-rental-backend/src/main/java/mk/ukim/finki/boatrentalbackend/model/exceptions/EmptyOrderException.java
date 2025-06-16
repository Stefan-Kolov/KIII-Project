package mk.ukim.finki.boatrentalbackend.model.exceptions;

public class EmptyOrderException extends RuntimeException {

    public EmptyOrderException() {
        super("The order is empty.");
    }

}
