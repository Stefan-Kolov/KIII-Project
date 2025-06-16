package mk.ukim.finki.boatrentalbackend.dto.domain;

import mk.ukim.finki.boatrentalbackend.model.domain.Boat;
import mk.ukim.finki.boatrentalbackend.model.domain.Category;

public record CreateBoatDto(
        String name,
        String description,
        String location,
        Double price,
        Integer capacity,
        Long categoryId
) {

    public Boat toBoat(Category category) {
        return new Boat(
                name,
                description,
                location,
                price,
                capacity,
                category
        );
    }

}
