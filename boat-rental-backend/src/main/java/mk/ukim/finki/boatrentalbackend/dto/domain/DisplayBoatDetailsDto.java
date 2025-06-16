package mk.ukim.finki.boatrentalbackend.dto.domain;

import mk.ukim.finki.boatrentalbackend.model.domain.Boat;
import mk.ukim.finki.boatrentalbackend.model.enums.BoatStatus;

public record DisplayBoatDetailsDto(
        Long id,
        String name,
        String description,
        String location,
        Double price,
        Integer capacity,
        BoatStatus status,
        DisplayCategoryDto category
) {

    public static DisplayBoatDetailsDto from(Boat boat) {
        return new DisplayBoatDetailsDto(
                boat.getId(),
                boat.getName(),
                boat.getDescription(),
                boat.getLocation(),
                boat.getPrice(),
                boat.getCapacity(),
                boat.getStatus(),
                DisplayCategoryDto.from(boat.getCategory())
        );
    }

}
