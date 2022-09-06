package Util;

import DAO.DrinksOrderRepository;
import DAO.FoodOrderRepository;

import java.util.Scanner;

public class DrinksMenu extends FoodMenu {
    static int  icetea = 5;
    static int  coffee = 7;
    static int ch;
    static int quantity;
    static int total;
    String again;
    Scanner sc = new Scanner(System.in);

    public void displayMenu() {

        DrinksOrderRepository d = new DrinksOrderRepository();
        System.out.println(d.getAllDrinksOrder());
    }

    public void bill() {
        System.out.println("Your Bill is " + "$" + total + "");
    }
    public void order() {
        while (true) {
            System.out.println("*****************");
            System.out.println("Enter your choice");
            System.out.println("*****************");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println(" Selected icetea  ");
                    System.out.println();
                    System.out.println(" Enter the desired quantity ");
                    System.out.println();
                    quantity = sc.nextInt();
                    total = total + quantity * icetea;

                    break;
                case 2:
                    System.out.println(" Selected coffee ");
                    System.out.println();
                    System.out.println(" Enter the desired quantity ");
                    System.out.println();
                    quantity = sc.nextInt();
                    total = total + quantity * coffee;
                    break;
                case 4:
                    System.exit(1);
                    break;
                default:
                    break;

            }
        }
    }


}
