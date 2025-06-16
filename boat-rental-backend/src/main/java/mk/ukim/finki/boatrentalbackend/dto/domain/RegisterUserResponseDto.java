package mk.ukim.finki.boatrentalbackend.dto.domain;

import mk.ukim.finki.boatrentalbackend.model.domain.User;
import mk.ukim.finki.boatrentalbackend.model.enums.Role;

public record RegisterUserResponseDto(
        String username,
        String name,
        String surname,
        String email,
        Role role
) {

    public static RegisterUserResponseDto from(User user) {
        return new RegisterUserResponseDto(
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getRole()
        );
    }

}
