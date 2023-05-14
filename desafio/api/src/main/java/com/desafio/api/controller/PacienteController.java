package com.desafio.api.controller;

import com.desafio.api.models.ConsultaModel;
import com.desafio.api.models.MedicoModel;
import com.desafio.api.models.PacienteModel;
import com.desafio.api.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PacienteController {
    @Autowired
    private PacienteService service;
    @Autowired
    private ConsultaController cService;

    @GetMapping(value = "/pacientes")
    @Operation(summary = "Listar pacientes", description = "Função da api para listagem de todos os pacientes")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity listarPaciente() {
        return new ResponseEntity(service.listarPacientes(), HttpStatus.OK);
    }

    @PostMapping(value = "/paciente/cadastrar")
    @Operation(summary = "Cadastrar paciente", description = "Função da api para cadastro de um novo paciente.")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity cadastrarPaciente(@RequestBody PacienteModel id, @RequestParam ConsultaModel cid, @RequestParam MedicoModel crm) {
        try {
            service.add(id);
            cid.setPaciente(id);
            crm.setCrm(id.getId());
            return new ResponseEntity("Paciente cadastrado com sucesso!!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Não foi possivel cadastrar o paciente! tente novamente. ", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/pacientes/deletar/{id}")
    @Operation(summary = "Excluir paciente", description = "Função da api para exclusão de um paciente.")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity excluirPaciente(@PathVariable Integer id) {
        try {
            service.remove(id);

            return new ResponseEntity("Excluido com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Cpf invalido", HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Atualizar paciente",description = "função da api para atualizar os dados de um paciente.")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity atualizarPacientes(Integer id, PacienteModel paciente) {
        try {
            service.update(id, paciente);
            return new ResponseEntity("Paciente alterado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Não foi possivel alterar o paciente!Tente novamente", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/pacientes/listarporid")
    @Operation(summary = "Lista pacientes por id", description = "Função da api para listar pacientes via id")
    @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro na operação")
    @ApiResponse(responseCode = "500", description = "Erro inesperado na operação.")
    public ResponseEntity listarPorId(@RequestBody Integer id) {

        try {
            service.listarPorid(id);
            return new ResponseEntity<>("Paciente listado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Não foi possivel encontrar o paciente desejado!Tente novamente", HttpStatus.BAD_REQUEST);
        }

    }
}


