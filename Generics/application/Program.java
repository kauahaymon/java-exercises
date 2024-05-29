package application;

import entities.Product;
import services.CalculationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();
        list.add(new Product("Computer",890.50));
        list.add(new Product("Monitor",450.50));
        list.add(new Product("Ram",780.50));
        list.add(new Product("Mouse",90.50));
        list.add(new Product("Keyboard",120.50));

        CalculationService cs = new CalculationService();
        for (Product p : list) {
            System.out.println(p.getName() + ", " + p.getPrice());
        }
        Product x = CalculationService.max(list);
        System.out.println();
        System.out.println("Most expensive:");
        System.out.println(x);
        sc.close();
    }
}
