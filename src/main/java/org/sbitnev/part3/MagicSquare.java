package org.sbitnev.part3;

import java.util.Scanner;

public class MagicSquare {
    public static void main(String[] args) {
        int [] [] result = {{4, 9, 2}, {3, 5, 7}, {8, 1, 5}};
        System.out.println(MagicSquare.magicSquarerTranform(result));
    }

    public static int magicSquarerTranform(int [] [] initialArray) {

        int [] [] squares = new int [] [] {
                {8, 3, 4, 1, 5, 9, 6, 7, 2},
                {4, 3, 8, 9, 5, 1, 2, 7, 6},
                {8, 1, 6, 3, 5, 7, 4, 9, 2},
                {6, 1, 8, 7, 5, 3, 2, 9, 4},
                {2, 9, 4, 7, 5, 3, 6, 1, 8},
                {4, 9, 2, 3, 5, 7, 8, 1, 6},
                {2, 7, 6, 9, 5, 1, 4, 3, 8},
                {6, 7, 2, 1, 5, 9, 8, 3, 4}
        };

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < squares.length; i++) {
            int total = 0;
            for(int j = 0; j < squares[i].length; j++) {
                total += Math.abs(initialArray[j/3] [j % 3] - squares [i] [j]);
            }
            if(total < min) {
                min = total;
            }
        }


        int [] [] result = {{4, 3, 78}, {2, 7, 6}, {9, 5, 1}};
        return  min;
    }
}
