package br.com.runa.ecommerce.ecommerce.repository;

import br.com.runa.ecommerce.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Override
    List<Produto> findAll();

    Optional<Produto> findById(Long id);

    List<Produto> findByCategorias_id(Long id);
}
