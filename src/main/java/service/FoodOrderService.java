package service;

import DAO.FoodOrderRepository;

import org.example.FoodOrder;

import java.util.List;

public class FoodOrderService {
    FoodOrderRepository fo;

    public FoodOrderService(){

        fo = new FoodOrderRepository();
    }
    public List<FoodOrder> getAllFoodOrder(){

        return fo.getAllFoodOrder();
    }
    //public List<FoodOrder> getAllFoodOrderByPrizeID(int id){
       // return fo.getAllFoodOrderByPrizeID(id);
  //  }
    //public void addFoodOrder(String title, int id){
      //  FoodOrder existingFoodOrder = fo.getFoodOrderByprize(prize);
       // if(existingFoodOrder == null) {
        //    FoodOrder newFoodOrder = new FoodOrder(menuitems,prize);
          //  fo.addFoodOrder(newFoodOrder);
      //  }else{
//            do nothing
       // }
   // }
   // public List<FoodOrder> getAllFoodOrderBymenuitemsName(String name){
      //  int id = fo.getArtistIDFromName(name);
       // return fo.getAllFoodOrderByPrize(id);
    }

