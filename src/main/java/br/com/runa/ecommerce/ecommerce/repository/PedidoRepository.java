package br.com.runa.ecommerce.ecommerce.repository;

import br.com.runa.ecommerce.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
