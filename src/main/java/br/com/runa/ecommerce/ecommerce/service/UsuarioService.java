package br.com.runa.ecommerce.ecommerce.service;

import br.com.runa.ecommerce.ecommerce.DTO.UsuarioCreateRequestDTO;
import br.com.runa.ecommerce.ecommerce.model.Usuario;
import br.com.runa.ecommerce.ecommerce.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    public final UsuarioRepository userRep;
    UsuarioService(UsuarioRepository userRep){
        this.userRep = userRep;
    }

    public Usuario createUsuario(UsuarioCreateRequestDTO dados){

        return userRep.save(new Usuario(dados.username(), dados.password(), dados.email()));
    }
}
