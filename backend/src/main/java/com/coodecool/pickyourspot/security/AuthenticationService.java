package com.coodecool.pickyourspot.security;

import com.coodecool.pickyourspot.config.JwtService;
import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.model.Role;
import com.coodecool.pickyourspot.security.helper_models.AuthRequest;
import com.coodecool.pickyourspot.security.helper_models.AuthResponse;
import com.coodecool.pickyourspot.security.helper_models.RegisterRequest;
import com.coodecool.pickyourspot.storage.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public Optional<AuthResponse> register(RegisterRequest request) {
        Optional<AppUser> optUser = repository.findByUsername(request.getUsername());
        if (optUser.isPresent()) {
            return Optional.empty();
        }
        var user = AppUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        AuthResponse response = AuthResponse.builder()
                .token(jwtToken)
                .build();
        return Optional.of(response);
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
