package cevaja.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table
@Data
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column
    private LocalDate dataDeNascimento;

    @Column
    private String cpf;

    @Column
    private String usernameLogin;

    @Column
    private String senha;


}
