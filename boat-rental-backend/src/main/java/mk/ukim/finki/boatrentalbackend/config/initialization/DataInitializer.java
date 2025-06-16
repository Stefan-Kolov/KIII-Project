package mk.ukim.finki.boatrentalbackend.config.initialization;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.boatrentalbackend.model.domain.Boat;
import mk.ukim.finki.boatrentalbackend.model.domain.Category;
import mk.ukim.finki.boatrentalbackend.model.domain.User;
import mk.ukim.finki.boatrentalbackend.model.enums.Role;
import mk.ukim.finki.boatrentalbackend.repository.BoatRepository;
import mk.ukim.finki.boatrentalbackend.repository.CategoryRepository;
import mk.ukim.finki.boatrentalbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Component
public class DataInitializer {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final BoatRepository boatRepository;

    public DataInitializer(
            PasswordEncoder passwordEncoder,
            UserRepository userRepository,
            CategoryRepository categoryRepository,
            BoatRepository boatRepository
    ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.boatRepository = boatRepository;
    }

    @Autowired
    private DataSource dataSource;



    @PostConstruct
    public void init() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String url = connection.getMetaData().getURL();       // This gives the JDBC URL string
            String user = connection.getMetaData().getUserName(); // This gives the DB username
            System.out.println("Connected to DB URL: " + url);
            System.out.println("DB User: " + user);
        } catch (SQLException e) {
            System.err.println("Failed to get DB connection info: " + e.getMessage());
        }


        System.out.println("Datasource URL: " + dataSource.getConnection());
        userRepository.save(new User(
                "customer",
                passwordEncoder.encode("customer"),
                "customer",
                "customer",
                "customer@email.com",
                Role.ROLE_CUSTOMER
        ));

        userRepository.save(new User(
                "owner",
                passwordEncoder.encode("owner"),
                "owner",
                "owner",
                "owner@email.com",
                Role.ROLE_OWNER
        ));

        userRepository.save(new User(
                "admin",
                passwordEncoder.encode("admin"),
                "admin",
                "admin",
                "admin@email.com",
                Role.ROLE_ADMIN
        ));
        userRepository.flush();


        categoryRepository.save(new Category(
                "Yacht",
                "Yacht"
        ));
        categoryRepository.save(new Category(
                "Jet Ski",
                "Jet Ski"
        ));
        categoryRepository.flush();
        List<Category> categories = categoryRepository.findAll();

        boatRepository.save(new Boat("Kawasaki","Desc", "Ohrid",550.0,10, categories.get(0)));
        boatRepository.save(new Boat("SeaDoo","Desc", "Ohrid",150.0,2, categories.get(1)));
        boatRepository.flush();

    }

}
