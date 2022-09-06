package service;

import DAO.FoodOrderRepository;

import org.example.FoodOrder;

import java.util.List;

public class FoodOrderService {
    FoodOrderRepository fr;

    public FoodOrderService() {

        fr = new FoodOrderRepository();
    }

    public List<FoodOrder> getAllFoodOrder() {

        return fr.getAllFoodOrder();
    }
}


