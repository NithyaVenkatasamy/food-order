package org.example;

public class Order {
    String menuitems;

    public Order(String menuitems) {
        this.menuitems = menuitems;
    }
    public String toString (){
        return menuitems + "menuitems";
    }
    public String getmenuitems () {
        return menuitems;
    }
    public void setmenuitems (String username){

        this.menuitems = menuitems;
    }
}

