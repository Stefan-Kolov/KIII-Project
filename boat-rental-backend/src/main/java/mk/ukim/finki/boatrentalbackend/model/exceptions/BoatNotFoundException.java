package mk.ukim.finki.boatrentalbackend.model.exceptions;

public class BoatNotFoundException extends RuntimeException {

    public BoatNotFoundException(Long id) {
        super(String.format("Boat with ID %s does not exist.", id));
    }

}
