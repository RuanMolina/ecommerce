package br.com.runa.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity(name = "Produto")
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valor;

    @ManyToMany
    private List<Categoria> categorias;

    public Produto(String nome, BigDecimal valor,List<Categoria> categorias) {
        this.nome = nome;
        this.valor = valor;
        this.categorias = categorias;
    }


}
