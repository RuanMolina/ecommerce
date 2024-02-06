package br.com.runa.ecommerce.ecommerce.repository;

import br.com.runa.ecommerce.ecommerce.model.Produto;
import br.com.runa.ecommerce.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findById(Long id);
}
