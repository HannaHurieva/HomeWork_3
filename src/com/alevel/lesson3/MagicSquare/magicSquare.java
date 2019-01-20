package com.alevel.lesson3.MagicSquare;

import java.util.Arrays;
import java.util.Scanner;

// Проверить, является ли введенный пользователем квадрат размером n x n -  магическим.
public class magicSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the size of the square matrix:");
        int size = in.nextInt();
        int[][] matrix = getInputMatrix(size);
        getPrintMatrix(matrix, size);
        int[] checkSum = getCheckSums(matrix, size);
        System.out.println("Array of check sums " + Arrays.toString(checkSum));
        boolean flag = true;
        for (int i = 1; i < checkSum.length; i++) {
            if (checkSum[0] != checkSum[i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Your matrix is magic square!");
        } else System.out.println("Your matrix is NOT magic square...");
    }

    private static int[] getCheckSums(int[][] square, int size) {
        int[] checkSum = new int[2 * size + 2];
        int sumDiagPrimary = 0, sumDiagSecond = 0;

        for (int i = 0; i < size; i++) {
            sumDiagPrimary += square[i][i];
            sumDiagSecond += square[i][size - 1 - i];
            int sumRows = 0, sumColumns = 0;
            for (int j = 0; j < size; j++) {
                sumRows += square[i][j];
                sumColumns += square[j][i];
            }
            checkSum[i] = sumRows;
            checkSum[size + i] = sumColumns;
        }
        checkSum[2 * size] = sumDiagPrimary;
        checkSum[2 * size + 1] = sumDiagSecond;
        return checkSum;
    }

    private static int[][] getInputMatrix(int size) {
        Scanner in = new Scanner(System.in);
        int[][] square = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Input matrix item[" + i + "][" + j + "]:");
                square[i][j] = in.nextInt();
            }
        }
        in.close();
        return square;
    }

    private static void getPrintMatrix(int[][] square, int size) {
        System.out.println("Matrix :");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }
}