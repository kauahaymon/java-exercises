package application;

import model.entities.Account;
import model.exceptions.ExceededValueException;
import model.exceptions.InsufficientBalanceException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account acc = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.println();
            System.out.print("Enter the amount for withdraw: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);

            System.out.println("New balance: " + acc.getBalance());
            sc.close();
        }
        catch (ExceededValueException | InsufficientBalanceException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Something went wrong");
        }
    }
}
