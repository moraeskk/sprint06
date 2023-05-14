package com.desafio.api.Authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class registroRequest {

    private String primeiroNome;
    private String sobrenome;
    private String email;
    private String passoword;
}
