package com.jk.mvc;

import android.util.Log;

import com.jk.mvc.controller.UserController;
import com.jk.mvc.model.User;

import java.util.ArrayList;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-06-12
 */
public class UserSingleton {
    private static UserSingleton userSingleton; //lazy initialization

    private ArrayList<User> userList; //list of users

    //method with the same name as class to initialize ArrayList only once when the very first
    //object of the class is created
    private UserSingleton() {
        userList = new ArrayList<User>();
    }

    //returns a singular, equal instance of UserSingleton class
    public static UserSingleton getInstance() {
        if (userSingleton == null) {
            userSingleton = new UserSingleton();
        }

        return userSingleton;
    }

    //method to assign new user into the ArrayList
    public void addUser(User newUser) {
        userList.add(newUser);
        Log.d("UserSingleton", "New user added \n " + newUser.toString());
        //UserController.insertUser(newUser);
    }

    public User getUserByEmail(String email) {
        for (User currentUser: userList) {
            //checking if the current object is the same as we are searching
            if (currentUser.getEmail().equals(email)) {
                //user account found and returning object
                return currentUser;
            }
        }

        //user account does not exist
        return null;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public boolean validateUser(String email, String password) {
        for (User currentUser : userList) {
            if (currentUser.getEmail().equals(email) && currentUser.getPassword().equals(password)) {
                return true; //valid user found
            }
        }

        return false; //user not found or is invalid
    }
}
