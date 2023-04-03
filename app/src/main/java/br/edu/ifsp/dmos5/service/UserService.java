package br.edu.ifsp.dmos5.service;

import br.edu.ifsp.dmos5.model.Contact;
import br.edu.ifsp.dmos5.model.User;

public class UserService {

    public void addContact(Contact contact, User user){
        user.getContactList().add(contact);
    }

    public void removeContact(Contact contact, User user){
        user.getContactList().remove(contact);
    }

}
