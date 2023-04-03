package br.edu.ifsp.dmos5.model.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super("Usuário não encontrado!");
    }
}
