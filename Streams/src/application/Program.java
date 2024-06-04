package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        String path = sc.next();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Employee> employees = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String email = fields[1];
                double empSalary = Double.parseDouble(fields[2]);
                employees.add(new Employee(name, email, empSalary));
                line = br.readLine();
            }
            System.out.println("Email of people whose salary is more than: "
                    + String.format("%.2f", salary));

            // Emails of the employees gaining more than -salary input-
            List<String> emails = employees.stream()
                    .filter(s -> s.getSalary() > salary)
                    .map(Employee::getEmail)
                    .toList();

            emails.forEach(System.out::println);

            // Sum of salary of employees that starts with 'M'
            double sumSalary = employees.stream()
                    .filter(n -> n.getName().charAt(0) == 'M')
                    .map(Employee::getSalary)
                    .reduce(0.0, Double::sum);

            System.out.print("Sum of salary of people whose name starts with 'M': "
                    + String.format("%.2f", sumSalary));

        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
