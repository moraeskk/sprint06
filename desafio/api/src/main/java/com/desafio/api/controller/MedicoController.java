package com.desafio.api.controller;

import com.desafio.api.models.MedicoModel;
import com.desafio.api.service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicoController {

    @Autowired

    private MedicoService service;

    @GetMapping(value = "/medicos")
    @Operation(summary = "Listar medicos", description = "Função da api para listagem de todos os medicos")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity listarMedicos() {
        return new ResponseEntity(service.listarMedicos(), HttpStatus.OK);
    }

    @PostMapping(value = "/medico/cadastrar")
    @Operation(summary = "Cadastrar médico", description = "Função da api para cadastro de um novo médico.")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity cadastrarMedico(@RequestBody MedicoModel crm) {
        try {
            service.add(crm);
            return new ResponseEntity("Médico cadastrado com sucesso!!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Não foi possivel cadastrar o médico! tente novamente. ", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/medico/deletar/{id}")
    @Operation(summary = "Excluir médico", description = "Função da api para exclusão de um medico.")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity excluirMedico(@PathVariable Integer crm) {
        try {
            service.remove(crm);

            return new ResponseEntity("Excluido com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Crm invalido", HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "medico/{id}")
    @Operation(summary = "Atualizar médico", description = "função da api para atualizar os dados de um médico.")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity atualizarMedicos(Integer crm, MedicoModel medico) {
        try {
            service.update(crm, medico);
            return new ResponseEntity("médico alterado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Não foi possivel alterar o médico!Tente novamente", HttpStatus.BAD_REQUEST);
        }
    }
}
