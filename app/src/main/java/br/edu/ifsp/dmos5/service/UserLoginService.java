package br.edu.ifsp.dmos5.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.edu.ifsp.dmos5.model.User;
import br.edu.ifsp.dmos5.model.exception.UserLoggedException;
import br.edu.ifsp.dmos5.model.exception.UserNotFoundException;
import br.edu.ifsp.dmos5.model.exception.UserNotLoggedException;
import br.edu.ifsp.dmos5.repository.UserLoginRepository;

public class UserLoginService {

    private UserLoginRepository userLoginRepository;
    private MessageDigest messageDigest;

    public UserLoginService(){
        try{
            messageDigest = MessageDigest.getInstance("MD5");
        }catch(NoSuchAlgorithmException ex){
            messageDigest = null;
        }

        userLoginRepository = new UserLoginRepository();
    }

    public boolean loginUser(User user) throws UserLoggedException, UserNotFoundException {
        if (user != null) {
           return userLoginRepository.loginUser(user);
        }
        return false;
    }

    public void logoffUser(User user) throws UserNotLoggedException, UserNotFoundException {
        if(user != null){
            userLoginRepository.logoffUser(user);
        }
    }

    public void addUser(User user){
        if(user != null){
            user.setHashLogin(getHashByPassword(user.getPassword()));
            userLoginRepository.addUser(user);
        }
    }

    public String getHashByPassword(String password) {
        messageDigest.update(password.getBytes());
        byte[] digestedPassword = messageDigest.digest();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digestedPassword.length; i++) {
            sb.append(Integer.toString((digestedPassword[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

}
