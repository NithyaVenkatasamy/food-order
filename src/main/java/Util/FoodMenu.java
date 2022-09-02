package Util;

import DAO.FoodOrderRepository;
import org.example.FoodOrder;

import java.util.List;
import java.util.Scanner;

import static org.example.FoodOrder.menuItems;
import static org.example.FoodOrder.prize;

public class FoodMenu {
    int fries = 5;
    int pizza = 20;
    int burger = 10;
    int ch;
    int quantity;
    static int total;
    String again;
    Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {
        FoodMenu food = new FoodMenu();
        food.displayMenu();
        food.bill();
        food.order();
    }
    public void displayMenu(){
        FoodOrderRepository fr = new FoodOrderRepository();
        List<FoodOrder> folist = fr.getAllFoodOrder();
        for(FoodOrder f:folist){
            System.out.println(f);
        }
       // System.out.println(fr.getAllFoodOrder());

    }
    public void bill(){
        System.out.println("Your Bill is " + "$" + total + "");

    }
    public void order(){
        while (true) {
            System.out.println("*****************");
            System.out.println("Enter your choice");
            System.out.println("*****************");
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
        }

    }
}
