package br.com.runa.ecommerce.ecommerce.DTO;

import br.com.runa.ecommerce.ecommerce.model.Categoria;

import java.math.BigDecimal;
import java.util.List;

public record ProdutoCreateRequestDTO(
        String nome,
        BigDecimal valor,
        List<Categoria> categorias) {
}
