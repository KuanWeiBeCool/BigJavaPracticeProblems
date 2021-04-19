package com.kuan;

public class PrintBalance {
    public static void main(String[] args) {
        int balance = 1000;
        final double interest = 0.05;
        int year = 1;
        while (year <= 3) {
            balance *= (1 + interest);
            System.out.printf("Year %d's balance is %d%n", year, balance);
            year += 1;
        }
    }
}
