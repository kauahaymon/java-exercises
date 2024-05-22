package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> list = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            switch (type) {
                case 'c':
                    list.add(new Product(name, price));
                    break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYY): ");
                    Date date = sdf.parse(sc.next());
                    list.add(new UsedProduct(name, price, date));
                    break;
                case 'i':
                    System.out.print("Customs fee: ");
                    double customsFee = sc.nextDouble();
                    list.add(new ImportedProduct(name, price, customsFee));
                    break;
                default:
                    break;
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product p : list) {
            System.out.println(p.priceTag());
        }
        sc.close();
    }
}

