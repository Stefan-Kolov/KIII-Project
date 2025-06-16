package mk.ukim.finki.boatrentalbackend.repository;

import mk.ukim.finki.boatrentalbackend.model.domain.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {
}
