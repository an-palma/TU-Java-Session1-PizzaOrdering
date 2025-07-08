package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class PizzaOrdering {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> pizzas = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");

        do {
            System.out.print("\nChoose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Pizza type: ");
                    String pizzaType = sc.next();
                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();

                    while (quantity <= 0) {
                        System.out.println("Quantity must be a positive integer. Please enter a valid number and try again.");
                        System.out.print("Quantity: ");
                        quantity = sc.nextInt();
                    }

                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;
                case 2:
                    System.out.print("Order number to update: ");
                    int updateIndex = sc.nextInt();
                    System.out.print("New quantity: ");
                    int newQuantity = sc.nextInt();

                    while (newQuantity <= 0) {
                        System.out.println("Quantity must be a positive integer. Please enter a valid number and try again.");
                        System.out.print("Quantity: ");
                        newQuantity = sc.nextInt();
                    }

                    updateOrder(quantities, updateIndex-1, newQuantity);
                    break;
                case 3:
                    System.out.print("Order number to remove: ");
                    int removeIndex = sc.nextInt();

                    removeOrder(pizzas, quantities, removeIndex-1);
                    break;
                case 4:
                    printOrders(pizzas, quantities);
                    break;
                default:
                    break;
            }

        } while (choice != 5);
    }


    private static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity) {
        pizzas.add(pizzaType);
        quantities.add(quantity);
    }

    private static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {
        quantities.set(index, newQuantity);
    }

    private static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {
        pizzas.remove(index);
        quantities.remove(index);
    }

    private static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        System.out.println("--- Current Orders ---");
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.printf("%d. %s x %d\n", i+1, pizzas.get(i), quantities.get(i));
        }
    }
}