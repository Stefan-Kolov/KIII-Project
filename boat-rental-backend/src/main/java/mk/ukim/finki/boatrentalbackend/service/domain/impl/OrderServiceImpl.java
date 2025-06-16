package mk.ukim.finki.boatrentalbackend.service.domain.impl;

import mk.ukim.finki.boatrentalbackend.model.domain.Order;
import mk.ukim.finki.boatrentalbackend.model.domain.User;
import mk.ukim.finki.boatrentalbackend.model.enums.BoatStatus;
import mk.ukim.finki.boatrentalbackend.model.enums.OrderStatus;
import mk.ukim.finki.boatrentalbackend.model.exceptions.EmptyOrderException;
import mk.ukim.finki.boatrentalbackend.model.exceptions.UserNotFoundException;
import mk.ukim.finki.boatrentalbackend.repository.BoatRepository;
import mk.ukim.finki.boatrentalbackend.repository.OrderRepository;
import mk.ukim.finki.boatrentalbackend.repository.UserRepository;
import mk.ukim.finki.boatrentalbackend.service.domain.OrderService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BoatRepository boatRepository;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            UserRepository userRepository,
            BoatRepository boatRepository
    ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.boatRepository = boatRepository;
    }

    @Override
    public Optional<Order> findPending(String username) {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        return orderRepository
                .findByUserAndStatus(user, OrderStatus.PENDING);
    }

    @Override
    public Order findOrCreatePending(String username) {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        return findPending(username)
                .orElseGet(() -> orderRepository.save(new Order(user)));
    }

    @Override
    public Optional<Order> confirm(String username) {
        Optional<Order> order = findPending(username);
        if (order.isPresent() && order.get().getBoats().isEmpty())
            throw new EmptyOrderException();
        order.get().getBoats().forEach(boat -> boat.setStatus(BoatStatus.RENTED));
        return order
                .map(o -> {
                    o.confirm();
                    return orderRepository.save(o);
                });
    }

    @Override
    public Optional<Order> cancel(String username) {
        Optional<Order> order = findPending(username);
        if (order.isPresent() && order.get().getBoats().isEmpty())
            throw new EmptyOrderException();
        order.get().getBoats().forEach(boat -> boat.setStatus(BoatStatus.AVAILABLE));
        return order
                .map(o -> {
                    o.cancel();
                    return orderRepository.save(o);
                });
    }

}
