package br.edu.ifsp.dmos5.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dmos5.model.User;
import br.edu.ifsp.dmos5.model.exception.UserFoundedException;
import br.edu.ifsp.dmos5.model.exception.UserLoggedException;
import br.edu.ifsp.dmos5.model.exception.UserNotFoundException;
import br.edu.ifsp.dmos5.model.exception.UserNotLoggedException;

public class UserLoginRepository {

    private List<User> userList = new ArrayList<>();

    public boolean loginUser(User user) throws UserLoggedException, UserNotFoundException {
        if(userList.size() > 0){
            if (user != null) {
                if (!getUser(user.getUsername()).getLogged()) {
                    userList.stream().filter(u -> u.getId() == user.getId()).findFirst().get().setLogged(true);
                } else if(userList.stream().filter(u -> u.getId() == user.getId()).findFirst().get() == null) {
                    return false;
                }else {
                    throw new UserLoggedException();
                }
            }
        }
        return false;
    }


    public void logoffUser(User user) throws UserNotLoggedException, UserNotFoundException {
        if (user != null) {
            if (getUser(user.getUsername()) != null) {
                userList.stream().filter(u -> u.getId() == user.getId()).findFirst().get().setLogged(false);
            } else {
                throw new UserNotLoggedException();
            }
        }
    }

    public User getUser(String username) throws UserNotFoundException {
        if (userList.stream().filter(u -> u.getUsername().equals(username)).findFirst().get() != null)
            return userList.stream().filter(u -> u.getUsername().equals(username)).findFirst().get();
        else
            throw new UserNotFoundException();
    }

    public void addUser(User user) throws UserFoundedException, UserNotFoundException {
        if (user != null) {
            if (getUser(user.getUsername()) == null) {
                userList.add(user);
            } else {
                throw new UserFoundedException();
            }
        }
    }


}
