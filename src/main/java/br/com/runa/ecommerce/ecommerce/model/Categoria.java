package br.com.runa.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Categoria")
@Table(name="categorias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String descricao;
}
