package DAO;

import Util.ConnectionUtil;
import org.example.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepository {
    Connection conn;
    public OrderRepository() {
        conn = ConnectionUtil.getConnection();
    }
   public boolean removeItem(Order or){
        try{
            PreparedStatement statement = conn.prepareStatement("delete from DrinksOrder where menuitems=?");
            statement.setString(1, or.getmenuitems());
            statement.executeUpdate();
            return true;
        }catch(
    SQLException e){
        e.printStackTrace();
    }
        return false;
  }
}

