package br.com.runa.ecommerce.ecommerce.repository;

import br.com.runa.ecommerce.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Override
    public List<Produto> findAll();

    public Optional<Produto> findById(Long id);

    public List<Produto> findByCategorias_id(Long id);
}
