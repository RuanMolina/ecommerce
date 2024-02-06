package br.com.runa.ecommerce.ecommerce.controller;

import br.com.runa.ecommerce.ecommerce.DTO.UsuarioCreateRequestDTO;
import br.com.runa.ecommerce.ecommerce.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService userService;
    public UsuarioController(UsuarioService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity createUsuario(@RequestBody @Valid UsuarioCreateRequestDTO dados, UriComponentsBuilder uriBuilder){
        var usuario = userService.createUsuario(dados);
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
