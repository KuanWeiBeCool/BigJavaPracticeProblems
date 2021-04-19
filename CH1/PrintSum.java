package com.kuan;

public class PrintSum {
    public static void main(String[] args) {
        int num = 1;
        int sum = 0;
        while (num <= 10) {
            sum += num;
            num += 1;
        }
        System.out.println(sum);
    }
}
