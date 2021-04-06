/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.List;
import models.Users;

/**
 *
 * @author 813017
 */
public class AccountService {
        public Users login(String username, String password) {
        UserDB userDB = new UserDB();

        try {
            Users user = userDB.getUser(username);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void update(String email, String password, String firstName, String lastName, Date dob, boolean isActive, boolean isAdmin) throws Exception {
        UserDB userDB = new UserDB();
        Users user = userDB.getUser(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setIsActive(isActive);
        user.setIsAdmin(isAdmin);
        userDB.update(user);
    }

    public void insert(String email, String password, String firstName, String lastName, Date dob, boolean isActive, boolean isAdmin) throws Exception {
        UserDB userDB = new UserDB();
        
        Date dateJoined = new Date();

        Users user = new Users(dateJoined, email, password, firstName, lastName, dob, isActive, isAdmin);
        userDB.insert(user);
    }

    public List<Users> getAll() throws Exception {
        UserDB userDB = new UserDB();

        return userDB.getAll();
    }
}
