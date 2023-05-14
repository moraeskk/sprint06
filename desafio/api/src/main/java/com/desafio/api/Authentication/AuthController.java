package com.desafio.api.Authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    private AuthService service;

    @PostMapping("/registrar")
    public ResponseEntity<AuthResponse> registrar(@RequestBody registroRequest request) {
        return ResponseEntity.ok(service.registrar(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody loginRequest request, String nomeDeUsuario) {
        return ResponseEntity.ok(service.loginResponse(request, nomeDeUsuario));
    }
}
