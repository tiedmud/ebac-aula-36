package br.com.ebac.ebac_modulo_50.controller;

import br.com.ebac.ebac_modulo_50.request.UsuarioRequest;
import br.com.ebac.ebac_modulo_50.response.UsuarioResponse;
import br.com.ebac.ebac_modulo_50.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<UsuarioResponse>> listarTodos() {
        List<UsuarioResponse> usuarios = service.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> criar(@RequestBody UsuarioRequest request) {
        service.criarUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarId(@PathVariable String id) throws Exception {
        service.deletarUsuarioPorId(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/testar")
    public void teste() {
        service.testar();
    }
}
