package com.kuan;

import java.util.Scanner;

public class CreateTilePattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = in.nextInt();
        System.out.println("Enter the number of columns: ");
        int col = in.nextInt();
        int i = 0;
        int j = 0;
        while (i < row) {
            if (i == 0 | i == row - 1) {
                while (j < col) {
                    System.out.print("\u25A0");
                    j += 1;
                }
            } else {
                while (j < col) {
                    if (j == 0 | j == col - 1) {
                        System.out.print("\u25A0");
                    } else {
                        System.out.print(" ");
                    }
                    j += 1;
                }
            }
            System.out.print("\n");
            i += 1;
            j = 0;
        }
    }
}
