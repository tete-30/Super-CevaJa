package cevaja.controller;


import cevaja.integration.service.PocTemperaturaService;
import cevaja.model.dto.UsuarioRequestDTO;
import cevaja.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/usuarios")
public class UsuariosController {

    private UsuarioService usuarioService;

    //Construtor da Classe
    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

    }

    @PostMapping
    public ResponseEntity<Void> adicionarUsuario (@RequestBody UsuarioRequestDTO usuarioRequest) {
        usuarioService.adicionar(usuarioRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
