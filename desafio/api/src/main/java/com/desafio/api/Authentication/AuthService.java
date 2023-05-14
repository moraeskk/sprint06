package com.desafio.api.Authentication;

import com.desafio.api.config.JwtService;
import com.desafio.api.models.UsuarioModel;
import com.desafio.api.repositories.UsuarioRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRespository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthResponse registrar(registroRequest request) {
        var user = UsuarioModel.builder()
                .primeiroNome(request.getPrimeiroNome())
                .sobrenome(request.getSobrenome())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassoword()))
                .build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .Token(jwtToken)
                .build();
    }

    public AuthResponse loginResponse(loginRequest request, String nomeDeUsuario) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getNomeDeUsuario(),
                        request.getPassword()
                )
        );
        var user = repository.findByNomeDeUsuario(request.getNomeDeUsuario())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .Token(jwtToken)
                .build();
    }
}

