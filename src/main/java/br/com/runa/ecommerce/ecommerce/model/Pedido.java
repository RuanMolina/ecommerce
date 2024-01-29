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
    BigDecimal valorTotal = new BigDecimal(0);
    LocalDateTime data;

    @OneToMany(fetch = FetchType.EAGER)
    List<ItemPedido> itensPedidos;

    public Pedido(List<Produto> produtos){
        data = LocalDateTime.now();
        produtos.forEach((item)->{
            valorTotal = valorTotal.add(item.getValor());
        });

    }


}
