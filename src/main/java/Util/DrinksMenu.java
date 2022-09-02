package Util;

import java.util.Scanner;

public class DrinksMenu {
    int icetea = 5;
    int coffee = 7;
    int ch;
    int quantity;
    static int total;
    String again;
    Scanner sc = new Scanner(System.in);
   // DrinksOrder drinks=new DrinksOrder();
    public void displayMenu() {
        System.out.println("   Welcome to our king   ");
        System.out.println();
        System.out.println("     1.icetea   $5   ");
        System.out.println("     2.coffee   $20  ");
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
