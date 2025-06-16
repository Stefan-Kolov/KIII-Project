package mk.ukim.finki.boatrentalbackend.repository;

import mk.ukim.finki.boatrentalbackend.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
