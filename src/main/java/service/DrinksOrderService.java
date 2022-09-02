package service;

import DAO.DrinksOrderRepository;

import org.example.DrinksOrder;

import java.util.List;

public class DrinksOrderService {
    DrinksOrderRepository d;

    public DrinksOrderService(){

        d = new DrinksOrderRepository();
    }
    public List<DrinksOrder> getAllDrinksOrder(){
        return d.getAllDrinksOrder();
    }
}
