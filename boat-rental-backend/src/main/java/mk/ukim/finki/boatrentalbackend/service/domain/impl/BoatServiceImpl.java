package mk.ukim.finki.boatrentalbackend.service.domain.impl;

import mk.ukim.finki.boatrentalbackend.model.domain.Boat;
import mk.ukim.finki.boatrentalbackend.model.domain.Order;
import mk.ukim.finki.boatrentalbackend.repository.BoatRepository;
import mk.ukim.finki.boatrentalbackend.repository.OrderRepository;
import mk.ukim.finki.boatrentalbackend.service.domain.BoatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatServiceImpl implements BoatService {

    private final BoatRepository boatRepository;
    private final OrderRepository orderRepository;

    public BoatServiceImpl(BoatRepository boatRepository, OrderRepository orderRepository) {
        this.boatRepository = boatRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Boat> findAll() {
        return boatRepository.findAll();
    }

    @Override
    public Optional<Boat> findById(Long id) {
        return boatRepository.findById(id);
    }

    @Override
    public Boat save(Boat boat) {
        return boatRepository.save(boat);
    }

    @Override
    public Optional<Boat> update(Long id, Boat boat) {
        return findById(id)
                .map(existingMenuItem -> {
                    existingMenuItem.setName(boat.getName());
                    existingMenuItem.setDescription(boat.getDescription());
                    existingMenuItem.setLocation(boat.getLocation());
                    existingMenuItem.setPrice(boat.getPrice());
                    existingMenuItem.setCapacity(boat.getCapacity());
                    existingMenuItem.setCategory(boat.getCategory());
                    return boatRepository.save(existingMenuItem);
                });
    }

    @Override
    public Optional<Boat> deleteById(Long id) {
        Optional<Boat> dish = findById(id);
        dish.ifPresent(boatRepository::delete);
        return dish;
    }

    @Override
    public Order addToOrder(Boat boat, Order order) {
        order.getBoats().add(boat);
        return orderRepository.save(order);
    }

    @Override
    public Order removeFromOrder(Boat boat, Order order) {
        order.getBoats().remove(boat);
        return orderRepository.save(order);
    }

}
