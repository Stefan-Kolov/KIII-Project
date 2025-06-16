package mk.ukim.finki.boatrentalbackend.dto.domain;

import mk.ukim.finki.boatrentalbackend.model.domain.Boat;
import mk.ukim.finki.boatrentalbackend.model.enums.BoatStatus;

import java.util.List;

public record DisplayBoatDto(
        Long id,
        String name,
        String description,
        String location,
        Double price,
        Integer capacity,
        BoatStatus status,
        Long categoryId
) {

    public static DisplayBoatDto from(Boat boat) {
        return new DisplayBoatDto(
                boat.getId(),
                boat.getName(),
                boat.getDescription(),
                boat.getLocation(),
                boat.getPrice(),
                boat.getCapacity(),
                boat.getStatus(),
                boat.getCategory().getId()
        );
    }

    public static List<DisplayBoatDto> from(List<Boat> boats) {
        return boats
                .stream()
                .map(DisplayBoatDto::from)
                .toList();
    }

}
