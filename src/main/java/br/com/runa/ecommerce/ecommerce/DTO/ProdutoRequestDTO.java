package br.com.runa.ecommerce.ecommerce.DTO;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        String nome,
        BigDecimal valor) {
}
