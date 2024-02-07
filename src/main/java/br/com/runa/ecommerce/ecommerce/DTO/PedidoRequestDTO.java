package br.com.runa.ecommerce.ecommerce.DTO;

import java.util.List;

public record PedidoRequestDTO(List<ItemPedidoDTO> itensPedidos, String formaPgmt, Long usuario_id) {
}
