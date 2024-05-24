package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        System.out.println("Enter the file path");
        System.out.println("Example - c:\\user\\Documents\\file.csv");

        System.out.print("> ");

        // putting file path into a String
        String filePath = sc.nextLine();

        File file = new File(filePath);
        String fileParent = file.getParent();

        // creating a new directory
        boolean success = new File(fileParent + "/out").mkdir();
        // creating a new file
        String targetFilePath = fileParent + "/out/summary.csv";

        // trying to read file content
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String item = br.readLine();
            while (item != null) {
                // create a vector to store each item line, divided by comma
                String[] fields = item.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                // add a new product to the list
                list.add(new Product(name, price, quantity));

                item = br.readLine();
            }

            // trying to write over the file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilePath))) {
                for (Product p: list) {
                    bw.write(p.getName() + "," + String.format("%.2f", p.total()));
                    bw.newLine();
                }
                System.out.println(targetFilePath + " < Created!");
            }

        }
        catch (IOException e) {
            System.out.println("Error in writing: " + e.getMessage());
        }
        sc.close();
    }
}