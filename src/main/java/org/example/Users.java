package org.example;

public class Users {
    String allUsers;
    String username;
    String password;
public Users(String username,String password){
    this.username=username;
    this.password=password;

}
    public String toString () {
        return username + ": password " + password;
    }
    public String getUserName () {
        return username;
    }
    public void setUserName (String username){

        this.username = username;
    }

    public String getPassword () {

        return password;
    }
    public void setPassword ( int Password){

        this.password = password;
    }

}
