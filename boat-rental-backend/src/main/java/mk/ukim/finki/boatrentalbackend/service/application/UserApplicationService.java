package mk.ukim.finki.boatrentalbackend.service.application;

import mk.ukim.finki.boatrentalbackend.dto.domain.LoginUserRequestDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.LoginUserResponseDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.RegisterUserRequestDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.RegisterUserResponseDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto);

    Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto);

    Optional<RegisterUserResponseDto> findByUsername(String username);
}
