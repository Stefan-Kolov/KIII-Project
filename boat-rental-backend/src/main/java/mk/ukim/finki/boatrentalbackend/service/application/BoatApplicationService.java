package mk.ukim.finki.boatrentalbackend.service.application;


import mk.ukim.finki.boatrentalbackend.dto.domain.CreateBoatDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.DisplayBoatDetailsDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.DisplayBoatDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.DisplayOrderDto;

import java.util.List;
import java.util.Optional;

public interface BoatApplicationService {
    List<DisplayBoatDto> findAll();

    Optional<DisplayBoatDto> findById(Long id);

    Optional<DisplayBoatDetailsDto> findByIdWithDetails(Long id);

    DisplayBoatDto save(CreateBoatDto createBoatDto);

    Optional<DisplayBoatDto> update(Long id, CreateBoatDto createBoatDto);

    Optional<DisplayBoatDto> deleteById(Long id);

    DisplayOrderDto addToOrder(Long id, String username);

    DisplayOrderDto removeFromOrder(Long id, String username);
}
