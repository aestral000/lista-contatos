package br.edu.ifsp.dmos5.model.exception;

public class UserFoundedException extends RuntimeException{

    public UserFoundedException(){
        super("Usuário já cadastrado!");
    }
}
