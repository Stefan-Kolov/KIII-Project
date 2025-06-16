package mk.ukim.finki.boatrentalbackend.repository;

import mk.ukim.finki.boatrentalbackend.model.domain.Order;
import mk.ukim.finki.boatrentalbackend.model.domain.User;
import mk.ukim.finki.boatrentalbackend.model.enums.BoatStatus;
import mk.ukim.finki.boatrentalbackend.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByUserAndStatus(User user, OrderStatus status);
}
