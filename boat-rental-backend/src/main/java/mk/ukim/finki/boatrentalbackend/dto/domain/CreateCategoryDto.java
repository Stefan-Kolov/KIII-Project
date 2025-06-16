package mk.ukim.finki.boatrentalbackend.dto.domain;

import mk.ukim.finki.boatrentalbackend.model.domain.Category;

public record CreateCategoryDto(
        String name,
        String description
) {

    public Category toCategory() {
        return new Category(name, description);
    }

}
