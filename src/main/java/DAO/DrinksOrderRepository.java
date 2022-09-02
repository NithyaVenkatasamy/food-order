package DAO;

import org.example.DrinksOrder;
import org.example.FoodOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrinksOrderRepository {
    Connection conn;
    public DrinksOrderRepository(){

        conn = Util.ConnectionUtil.getConnection();
    }
    public List<DrinksOrder> getAllDrinksOrder() {
        List<DrinksOrder> allDrinksOrder = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From DrinksOrder");
            while (rs.next()) {
                DrinksOrder loadedDrinksOrder = new DrinksOrder(rs.getString("menuitems"), rs.getInt("prize"));
                allDrinksOrder.add(loadedDrinksOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDrinksOrder;
    }
    public List<DrinksOrder> getAllDrinksOrderByprize(int id){
        List<DrinksOrder> DrinksOrder = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("Select * from DrinksOrder where prize = ?");

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                DrinksOrder loadedDrinksOrder = new DrinksOrder(rs.getString("menuitems"), rs.getInt("prize"));
                DrinksOrder.add(loadedDrinksOrder);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(DrinksOrder.size() == 0){
            return DrinksOrder;
        }else{
            return DrinksOrder;
        }

    }
    public void addDrinksOrder(DrinksOrder d){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into DrinksOrder(menuitems, prize) " +
                    "values (?, ?)");
            statement.setString(1, d.getMenuItems());
            statement.setInt(2, d.getPrize());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public DrinksOrder getDrinksOrderByMenuItems(String menuItems){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from DrinksOrder where menuitems = ?");
            statement.setString(1, menuItems);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                DrinksOrder d = new DrinksOrder(rs.getString("menuitems"), rs.getInt("prize"));
                return d;
            }
        }catch(SQLException e){

        }
        return null;
    }
}
