package abstract_instances;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        List<TaxPayer> list = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            System.out.println("Tax payer #1 data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();
            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthSpending = sc.nextDouble();
                list.add(new Individual(name, annualIncome, healthSpending));
            }
            else {
                System.out.print("Number of employees: ");
                int numberEmployee = sc.nextInt();
                list.add(new Company(name, annualIncome, numberEmployee));
            }
        }

        System.out.println();
        double totalTaxes = 0.0;
        System.out.println("Taxes paid:");
        for (TaxPayer tp : list) {
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));
            totalTaxes += tp.getAnnualIncome();
        }

        System.out.println();
        System.out.println("Total taxes: " + String.format("%.2f", totalTaxes));

        sc.close();
    }
}

