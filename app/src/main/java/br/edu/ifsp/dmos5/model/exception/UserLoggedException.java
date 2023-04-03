package br.edu.ifsp.dmos5.model.exception;

public class UserLoggedException extends RuntimeException{

   public UserLoggedException(){
      super("Usuário já logado!");
   }

}
