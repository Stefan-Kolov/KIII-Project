package mk.ukim.finki.boatrentalbackend.service.domain;

import mk.ukim.finki.boatrentalbackend.model.domain.Boat;
import mk.ukim.finki.boatrentalbackend.model.domain.Order;

import java.util.List;
import java.util.Optional;

public interface BoatService {
    List<Boat> findAll();

    Optional<Boat> findById(Long id);

    Boat save(Boat menuItem);

    Optional<Boat> update(Long id, Boat boat);

    Optional<Boat> deleteById(Long id);

    Order addToOrder(Boat boat, Order order);

    Order removeFromOrder(Boat boat, Order order);
}
