package cevaja.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRequestDTO {
    private String nome;

    private String sobrenome;

    private LocalDate dataDeNascimento;

    private String cpf;

    private String usernameLogin;

    private String senha;

}
