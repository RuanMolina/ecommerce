package br.com.runa.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private Boolean ativo;

    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.ativo = true;
    }
}
