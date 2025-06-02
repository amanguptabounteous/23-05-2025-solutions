package assignment;

import java.util.Scanner;

class TaxCalc {
    private double sal;
    private int age;
    private double inv;
    private double ins;
    private double loan;

    public TaxCalc(double sal, int age, double inv, double ins, double loan) {
        this.sal = sal;
        this.age = age;
        this.inv = Math.min(inv, 150000);              // 80C: Max ₹1.5L
        this.ins = Math.min(ins, age >= 60 ? 50000 : 25000); // 80D: Max ₹25k/50k
        this.loan = Math.min(loan, 200000);            // 24: Max ₹2L
    }

    public double getTaxable() {
        double ded = inv + ins + loan;
        return Math.max(0, sal - ded);
    }

    public double getTax() {
        double income = getTaxable();
        double tax = 0;

        if (age < 60) {
            tax = calc(income, 250000);
        } else if (age <= 80) {
            tax = calc(income, 300000);
        } else {
            tax = calc(income, 500000);
        }

        return tax;
    }

    private double calc(double income, double limit) {
        double tax = 0;

        if (income <= limit) {
            return 0;
        } else if (income <= 500000) {
            tax += (income - limit) * 0.05;
        } else if (income <= 1000000) {
            tax += (500000 - limit) * 0.05;
            tax += (income - 500000) * 0.20;
        } else {
            tax += (500000 - limit) * 0.05;
            tax += 500000 * 0.20;
            tax += (income - 1000000) * 0.30;
        }

        return tax;
    }
}

public class TaxMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter annual salary (INR): ");
        double sal = sc.nextDouble();

        System.out.println("Enter age: ");
        int age = sc.nextInt();

        System.out.println("Enter tax-saving investment (INR): ");
        double inv = sc.nextDouble();

        System.out.println("Enter health insurance premium (INR): ");
        double ins = sc.nextDouble();

        System.out.println("Enter home loan interest (INR): ");
        double loan = sc.nextDouble();

        TaxCalc t = new TaxCalc(sal, age, inv, ins, loan);
        double tax = t.getTax();

        System.out.printf("\nTotal Tax Payable: ₹%.2f\n", tax);

        sc.close();
    }
}

