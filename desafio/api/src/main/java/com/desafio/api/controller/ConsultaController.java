package com.desafio.api.controller;

import com.desafio.api.models.ConsultaModel;
import com.desafio.api.models.MedicoModel;
import com.desafio.api.service.ConsultaService;
import com.desafio.api.service.MedicoService;
import com.desafio.api.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.aspectj.weaver.CrosscuttingMembers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Security;

@RestController
public class ConsultaController {
    @Autowired
    private ConsultaService service;
    @Autowired
    private MedicoService mService;
    @Autowired
    private PacienteService pService;

    @GetMapping(value = "/consulta")
    @Operation(summary = "Listar consultas", description = "Função da api para listagem de todas as consultas", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity listarConsultas() {
        return new ResponseEntity(service.listarConsultas(), HttpStatus.OK);
    }

    @PostMapping(value = "/consulta/cadastrar")
    @Operation(summary = "Cadastrar consulta", description = "Função da api para cadastro de um nova nova consulta.")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity cadastrarConsulta(@RequestBody ConsultaModel cid) {
        try {
            service.add(cid);
            return new ResponseEntity("consulta cadastrada com sucesso!!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Não foi possivel cadastrar a consulta! tente novamente. ", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/consulta/deletar/{id}")
    @Operation(summary = "Excluir consulta", description = "Função da api para exclusão de uma consulta.")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity excluirConsulta(@PathVariable Integer cid) {
        try {
            service.remove(cid);

            return new ResponseEntity("Excluido com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("id invalido", HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "consulta/{id}")
    @Operation(summary = "remarcar consulta", description = "função da api para atualizar os dados de uma consulta.")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity atualizarConsulta(Integer cid, ConsultaModel consulta) {
        try {
            service.update(cid, consulta);
            return new ResponseEntity("médico alterado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Não foi possivel alterar o médico!Tente novamente", HttpStatus.BAD_REQUEST);
        }
    }
}
