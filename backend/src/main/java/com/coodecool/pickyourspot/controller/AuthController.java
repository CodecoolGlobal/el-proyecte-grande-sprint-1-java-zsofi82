package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.security.AuthenticationService;
import com.coodecool.pickyourspot.security.helper_models.AuthRequest;
import com.coodecool.pickyourspot.security.helper_models.AuthResponse;
import com.coodecool.pickyourspot.security.helper_models.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/registration")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request
    ) {
        Optional<AuthResponse> response = service.register(request);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User Already exists");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}
