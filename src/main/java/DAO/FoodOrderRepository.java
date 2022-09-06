package DAO;


import Util.ConnectionUtil;
import org.example.FoodOrder;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class FoodOrderRepository {
    Connection conn;

    public FoodOrderRepository() {
        conn = ConnectionUtil.getConnection();
    }


    public List<FoodOrder> getAllFoodOrder() {
        List<FoodOrder> allFoodOrder = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From FoodOrder");
            while (rs.next()) {

                FoodOrder loadedFoodOrder = new FoodOrder(rs.getString("menuitems"), rs.getInt("prize"));
                System.out.println(loadedFoodOrder);
                allFoodOrder.add(loadedFoodOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allFoodOrder;

    }

    public FoodOrder updateFoodOrder(){
        try{
            PreparedStatement statement = conn.prepareStatement("Update foodorder set menuitems='apple' where menuitems=?");
            //statement.setString(1, menu);
            statement.executeUpdate();
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                FoodOrder f = new FoodOrder(rs.getString("menuitems"));
                return f;
            }
        }catch(SQLException e){

        }
        return null;
    }


}




