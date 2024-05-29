package application;


import services.BrazilInterestService;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        BrazilInterestService bis = new BrazilInterestService(2.0);
        double payment = bis.payment(amount, months);

        System.out.println("Payment after " + months + " months:");
        System.out.printf("%.2f", payment);
        
        sc.close();
    }
}
