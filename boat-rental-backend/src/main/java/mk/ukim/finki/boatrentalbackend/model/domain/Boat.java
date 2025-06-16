package mk.ukim.finki.boatrentalbackend.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.boatrentalbackend.model.enums.BoatStatus;

@Data
@Entity
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String location;

    private Double price;

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private BoatStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public Boat() {
        this.status = BoatStatus.AVAILABLE;
    }

    public Boat(String name, String description, String location, Double price, Integer capacity, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.capacity = capacity;
        this.category = category;
        this.status = BoatStatus.AVAILABLE;
        this.location = location;
    }

    public void increaseQuantity() {
        capacity++;
    }

    public void decreaseQuantity() {
        capacity--;
    }

}
