package org.example;

import java.util.Scanner;

public class FoodOrder {
    public String menuItems;
    public int prize;
    public String menu;


    public FoodOrder(String menuItems, int prize){
            this.menuItems = menuItems;
            this.prize = prize;

        }
     public FoodOrder(String menuitems){
        this.menu=menuitems;
     }

        public String toString () {

        return menuItems + ": prize " + prize;
        }
        public String getMenuItems () {
            return menuItems;
        }
        public void setMenuItems (String menuItems){

        this.menuItems = menuItems;
        }

        public int getPrize () {

        return prize;
        }
        public void setPrize ( int prize){

        this.prize = prize;
        }

        public String getMenu(){
        return menu;
        }
        public void setMenu(String menu){
        this.menu=menu;
        }




}
