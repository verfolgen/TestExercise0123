package org.sbitnev.part3;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class MagicSquare {


    public static int magicSquarerTransform(int[][] initialArray) {

        final int magicConst = 15;
        return magicConst;
    }
    static int[] formingMagicSquare(int [][] s, int [][] squares){
        int min = Integer.MAX_VALUE;
        int[] val = new int[2];
        int k = 0;

        for (int i = 0; i < squares.length; i++) {
            int total = 0;
            for (int j = 0; j < squares[i].length; j++) {
                total += Math.abs(s[j/3][j%3] - squares[i][j]);
            }
            if (total < min) {min = total;k = i;}
        }
        val[0] = k;
        val[1] = min;
        return val;
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] s = new int[3][3];
        int[][] squares = new int[][]{
                {1, 5, 9, 6, 7, 2, 8, 3, 4},
                {1, 5, 9, 8, 3, 4, 6, 7, 2},
                {1, 6, 8, 9, 2, 4, 5, 7, 3},
                {1, 8, 6, 9, 4, 2, 5, 3, 7},
                {2, 4, 9, 6, 8, 1, 7, 3, 5},
                {2, 6, 7, 9, 1, 5, 4, 8, 3},
                {3, 4, 8, 5, 9, 1, 7, 2, 6},
                {3, 7, 5, 8, 6, 1, 4, 2, 9}
        };
        int[] val = new int[2];
        int coin;
        int k;

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }
        val = formingMagicSquare(s, squares);
        k = val[0];
        coin = val[1];
        System.out.println(coin);

        for (int j = 0; j < 9; j++) {
            System.out.print(squares[k][j] + " ");
            if ((j == 2) || (j == 5)) {
                System.out.println("");
            }
        }
    }

}
