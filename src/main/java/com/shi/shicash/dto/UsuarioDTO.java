package com.shi.shicash.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {

    @NotBlank(message = "O nome do usuario é obrigatório")
    @Size(min = 3, message = "O nome deve conter pelo menos 3 caracteres")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório")
    private String email;

    @NotBlank(message = "O número do documento é obrigatório")
    @Size(min = 7, message = "O documento deve conter pelo menos 7 caracteres")
    private String docNumero;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 4, message = "A senha deve conter pelo menos 4 caracteres")
    private String senha;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocNumero() {
        return docNumero;
    }

    public void setDocNumero(String docNumero) {
        this.docNumero = docNumero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
