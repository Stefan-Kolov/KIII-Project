package mk.ukim.finki.boatrentalbackend.model.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Long id) {
        super(String.format("Category with ID %s does not exist.", id));
    }

}
