package br.com.runa.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pedido")
@Table(name = "pedidos")
@EqualsAndHashCode
@Setter
@Getter
@ToString
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorTotal = new BigDecimal(0);
    private BigDecimal valorFrete = new BigDecimal(0);

    private LocalDateTime dataPedido;

    @OneToMany(mappedBy = "pedido",fetch = FetchType.EAGER)
    private List<ItemPedido> itensPedidos;

    public Pedido(List<Produto> produtos){
        this.dataPedido = LocalDateTime.now();
        produtos.forEach((item)->{
            valorTotal = valorTotal.add(item.getValor());
        });

    }


}
