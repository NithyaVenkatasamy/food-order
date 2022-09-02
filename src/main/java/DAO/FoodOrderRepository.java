package DAO;


import Util.ConnectionUtil;
import org.example.FoodOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FoodOrderRepository {
    Connection conn;
    public FoodOrderRepository(){
        conn = ConnectionUtil.getConnection();
    }
    public List<FoodOrder> getAllFoodOrder(){
        List<FoodOrder> allFoodOrder = new LinkedList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From FoodOrder");
            while(rs.next()){
                /*
                FoodOrder loadedFoodOrder = new FoodOrder(rs.getString("menuitems"), rs.getInt("prize"));
                System.out.println(loadedFoodOrder);
                allFoodOrder.add(loadedFoodOrder);*/
                allFoodOrder.add(new FoodOrder(rs.getString("menuitems"),rs.getInt("prize")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allFoodOrder;
    }
    public List<FoodOrder> getAllFoodOrderByprize(int id){
        List<FoodOrder> foodOrder = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("Select * from FoodOrder where prize = ?");
//            parameterindexes start from 1 and go in order of the '?' in the sql string
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                FoodOrder loadedFoodOrder = new FoodOrder(rs.getString("menuitems"), rs.getInt("prize"));
                foodOrder.add(loadedFoodOrder);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(foodOrder.size() == 0){
            return foodOrder;
        }else{
            return foodOrder;
        }

    }
    public void addFoodOrder(FoodOrder f){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into FoodOrder(menuitems, prize) " +
                    "values (?, ?)");
            statement.setString(1, f.getMenuItems());
            statement.setInt(2, f.getPrize());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public FoodOrder getFoodOrderByMenuItems(String menuItems){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from FoodOrder where menuitems = ?");
            statement.setString(1, menuItems);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                FoodOrder f = new FoodOrder(rs.getString("menuitems"), rs.getInt("prize"));
                return f;
            }
        }catch(SQLException e){

        }
        return null;
    }
}
