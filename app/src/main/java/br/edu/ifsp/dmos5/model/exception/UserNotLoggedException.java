package br.edu.ifsp.dmos5.model.exception;

public class UserNotLoggedException extends RuntimeException{

    public UserNotLoggedException(){
        super("Usuário não está logado atualmente!");
    }

}
