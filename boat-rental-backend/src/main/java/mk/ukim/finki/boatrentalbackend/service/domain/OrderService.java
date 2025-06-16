package mk.ukim.finki.boatrentalbackend.service.domain;


import mk.ukim.finki.boatrentalbackend.model.domain.Order;

import java.util.Optional;

public interface OrderService {
    Optional<Order> findPending(String username);

    Order findOrCreatePending(String username);

    Optional<Order> confirm(String username);

    Optional<Order> cancel(String username);
}
