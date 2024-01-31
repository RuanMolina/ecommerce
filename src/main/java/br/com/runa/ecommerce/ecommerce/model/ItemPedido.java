package br.com.runa.ecommerce.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter@Entity(name = "ItemPedido")
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto", updatable = false)
    @JsonIgnore
    private Produto produto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pedido",updatable = false)
    @JsonIgnore
    private Pedido pedido;
    private Integer quantidade;
    private BigDecimal valor;

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade){
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = produto.getValor();
        this.valor.multiply(new BigDecimal(quantidade));
    }
}
