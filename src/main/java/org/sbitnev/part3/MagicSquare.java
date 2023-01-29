package org.sbitnev.part3;

import java.util.Scanner;

public class MagicSquare {

    public static int [] [] magicSquarerTranform(int [] [] initialArray) {
        int [] [] magicArray = new int [3] [3];

        Scanner sc = new Scanner(System.in);

        int sumDia = 0, sumRow = 0, sumCol = 0;

        for(int i = 0; i < 3; i ++){
            for(int j = 0; j <3; j ++) {
                System.out.println("Enter number " + "[" + i + "]" + " [" + j + "]");
                magicArray [i] [j] = sc.nextInt();

            }
        }

        for(int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                if (i == j) {
                    sumDia
                }
            }
        }

        int [] [] result = {{4, 3, 78}, {2, 7, 6}, {9, 5, 1}};
        return  result;
    }
}
