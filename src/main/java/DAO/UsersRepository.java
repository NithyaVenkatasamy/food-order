package DAO;

import Util.ConnectionUtil;
import org.example.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    Connection conn;
    public UsersRepository() {
        conn = ConnectionUtil.getConnection();
    }
    public boolean addUser(String username,String password){
        List<Users> allUsers = new ArrayList<>();
        try{
            PreparedStatement statement=conn.prepareStatement("insert into users(username,password)values(?,?);");
            statement.setString(1,username);
            statement.setString(2,password);
            statement.executeUpdate();
            statement=conn.prepareStatement("Select * From Users");
            ResultSet rs = statement.executeQuery();
            rs.next();
            Users loadedUsers = new Users(rs.getString("username"), rs.getString("password"));
            System.out.println(loadedUsers);
            allUsers.add(loadedUsers);
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }if(username.equals("Users")&& password.equals("Users")){
            return true;
        }else{
            return false;
        }

    }


}

