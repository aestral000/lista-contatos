package br.edu.ifsp.dmos5.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String username;
    private String password;
    private String hashLogin;
    private List<Contact> contactList;
    private boolean isLogged;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        isLogged = false;
        contactList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        if (hashLogin != null ? !hashLogin.equals(user.hashLogin) : user.hashLogin != null)
            return false;
        return contactList.equals(user.contactList);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (hashLogin != null ? hashLogin.hashCode() : 0);
        result = 31 * result + contactList.hashCode();
        return result;
    }

    public String getHashLogin() {
        return hashLogin;
    }

    public void setHashLogin(String hashLogin) {
        this.hashLogin = hashLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLogged(boolean isLogged){
        this.isLogged = isLogged;
    }

    public boolean getLogged(){
        return this.isLogged;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
