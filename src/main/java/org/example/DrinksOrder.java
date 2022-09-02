package org.example;

import java.util.Scanner;

public class DrinksOrder {

    public static String menuItems;
    public static int prize;
    public DrinksOrder(String menuItems, int prize){
        this.menuItems = menuItems;
        this.prize = prize;
    }



    public String tostring () {
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





}
