package com.kuan;

public class PrintProduct {
    public static void main(String[] args) {
        int num = 1;
        int product = 1;
        while (num <= 10) {
            product *= num;
            num += 1;
        }
        System.out.println(product);
    }

}
