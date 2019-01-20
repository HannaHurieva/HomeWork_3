package com.alevel.lesson3.Pascal;

import java.util.Scanner;

// Построить треугольник Паскаля высотой n строк. n вводит пользователь.
public class pascalTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input number N - number of rows of triangle Pascal:");
        int rowsOfTriangle = in.nextInt();
        long[][] triangleOfPascal = getPascalTriangle(rowsOfTriangle);
        printPascalTriangle(triangleOfPascal, rowsOfTriangle);
    }

    private static long[][] getPascalTriangle(int rows) {
        long[][] triangle = new long[rows][rows];
        for (int i = 0; i < rows; i++) {
            //the first and last element in the line is 1
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            //then we calculate the inner part of the line of the triangle
            for (int lineStep = 1; lineStep < i; lineStep++) {
                triangle[i][lineStep] = triangle[i - 1][lineStep - 1] + triangle[i - 1][lineStep];
            }
        }
        return triangle;
    }

    private static void printPascalTriangle(long[][] triangle, int rows) {
        //the longest character count
        int count = 0;
        long modulo = triangle[rows - 1][(rows - 1) / 2];
        while (modulo >= 1) {
            modulo = modulo / 10;
            count++;
        }
        for (int i = 0; i < rows; i++) {
            System.out.format("%" + ((rows - i) * (count /2+1)) + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.format("%" + (count + 1) + "d", triangle[i][j]);
            }
            System.out.println();
        }
    }
}