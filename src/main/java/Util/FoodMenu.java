package Util;


import DAO.DrinksOrderRepository;
import DAO.FoodOrderRepository;
import DAO.OrderRepository;
import DAO.UsersRepository;
import org.example.FoodOrder;
import org.example.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class FoodMenu {
    int fries = 5;
    int pizza = 20;
    int burger = 10;
    int dessert = 3;
    int  icetea = 5;
    int  coffee = 7;
    int ch;
    int quantity;

    static int total;
    String again;
    String username;
    String password;
    int number;
    String menuitems;
    String menu;

    Scanner sc = new Scanner(System.in);
    Scanner keyboard = new Scanner(System.in);



    public static void main(String[] args) {
        FoodMenu food = new FoodMenu();
        food.login();
        food.displayMenu();
        food.order();
        food.bill();


        DrinksMenu drinks=new DrinksMenu();
        drinks.displayMenu();
        List<FoodMenu>foodmenu=new ArrayList<FoodMenu>();
        FoodMenu fm = new FoodMenu();
        DrinksMenu dm = new DrinksMenu();

        foodmenu.add(fm);
        foodmenu.add(dm);

        for (FoodMenu foodMenu : foodmenu) {
            foodMenu.displayMenu();
            foodMenu.bill();
            foodMenu.order();
        }
    }
    public void login(){
        System.out.print("Enter username:");//username:user
        username = keyboard.nextLine();
        System.out.print("Enter password:");//password:user
        password = keyboard.nextLine();
        if(username.equals("Users") && password.equals("Users"))
        {
            System.out.println("Authentication Successful");
        }
        else
        {
            System.out.println("Authentication Failed");
        }
        UsersRepository ur = new UsersRepository();
        System.out.println(ur.addUser(username,password));
    }
    public void displayMenu(){
        FoodOrderRepository fr = new FoodOrderRepository();
        System.out.println(fr.getAllFoodOrder());
        System.out.println(fr.updateFoodOrder());
        DrinksOrderRepository d = new DrinksOrderRepository();
        System.out.println(d.getAllDrinksOrder());
    }

    public void bill(){

        System.out.println("Your Bill is " + "$" + total + "");

    }

    public void order(){
        while (true) {
            System.out.println("*****************");
            System.out.println("Enter your choice");
            System.out.println("*****************");
            do {
                System.out.println("Please enter a positive number!");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not a number!");
                    sc.next(); 
                }
                number = sc.nextInt();
            } while (number <= 0);
            System.out.println("Enter it again!");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println(" Selected fries ");
                    System.out.println();
                    System.out.println(" Enter the desired quantity ");
                    System.out.println();
                    quantity = sc.nextInt();
                    total = total + quantity * fries;
                    break;
                case 2:
                    System.out.println(" Selected pizza ");
                    System.out.println();
                    System.out.println(" Enter the desired quantity ");
                    System.out.println();
                    quantity = sc.nextInt();
                    total = total + quantity * pizza;
                    break;
                case 3:
                    System.out.println(" Selected burger");
                    System.out.println();
                    System.out.println(" Enter the desired quantity ");
                    System.out.println();
                    quantity = sc.nextInt();
                    total = total + quantity * burger;
                    break;
                case 4:
                    System.out.println(" Selected dessert");
                    System.out.println();
                    System.out.println(" Enter the desired quantity ");
                    System.out.println();
                    quantity = sc.nextInt();
                    total = total + quantity * dessert;
                    break;
                case 5:
                    System.out.println(" Selected icetea  ");
                    System.out.println();
                    System.out.println(" Enter the desired quantity ");
                    System.out.println();
                    quantity = sc.nextInt();
                    total = total + quantity * icetea;
                    break;
                case 6:
                    System.out.println(" Selected coffee ");
                    System.out.println();
                    System.out.println(" Enter the desired quantity ");
                    System.out.println();
                    quantity = sc.nextInt();
                    total = total + quantity * coffee;
                    break;

                case 7:
                    System.exit(1);
                    break;
                default:
                    break;


            }
            System.out.println("Any other orders yes/no");
            again = sc.next();
            if (again.equalsIgnoreCase("yes")) {
                order();
            } else if (again.equalsIgnoreCase("no")) {
                bill();
            } else {
                System.out.println("Invalid choice");
            }
            OrderRepository o = new OrderRepository();
            System.out.println(String.valueOf(o.removeItem(new Order("coffee"))));
            System.out.println("Thank You!");
        }

    }


}
