package mk.ukim.finki.boatrentalbackend.dto.domain;

public record LoginUserRequestDto(
        String username,
        String password
) {
}
