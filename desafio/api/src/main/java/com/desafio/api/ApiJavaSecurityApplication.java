package com.desafio.api;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//**Construir um microsserviço Spring, responsável pelo sistema de agendamento da clínica. Seu
//sistema deve preencher no mínimo os seguintes requisitos:
//1. Possuir pelo menos 3 entidades relacionadas e com seu CRUD completo.
//2. Utilizar Spring e Spring Data JPA para a criação do microsserviço.
//3. Possuir Swagger para documentação da API.
//4. Utilizar Spring Security com JWT para autenticação de Usuários.
//5. As rotas de login e cadastro não devem ser protegidas, enquanto todas as outras devem ser
//protegidas.
//6. Implementar testes unitários de pelo menos uma classe.
//7. A API deve ser publicada na plataforma Azure.
//Pode ser utilizado a abordagem “Code First” ou “Database First”, e a modelagem do Banco de
//Dados e Classes é recomendada.


@SpringBootApplication
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class ApiJavaSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiJavaSecurityApplication.class, args);
    }

}
