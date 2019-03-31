package org.kpi.fiot.io8322.oop.lab2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


/**
 * C5 = 1 транспонування
 * C7 = 4 тип елементів матриці float
 * C11 = 6 Обчислити суму найбільших елементів в стовпцях матриці з парними номерами
 * та найменших елементів в стовпцях матриці з непарними номерами
 */
public class Lab2 {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    public static void printMatric(String title, float[][] m) {
        System.out.println(title);
        System.out.println("*****************");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*****************");
    }

    public static void main(String[] argc) {
        float[][] B = {{1, 2, 3, 9},
                {4, 5, 6, 8},
                {7, 8, 9, 7}};
        Lab2.printMatric("Начальная матрица", B);
        float[][] C = new float[B[0].length][B.length];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                C[j][i] = B[i][j];
            }
        }
        Lab2.printMatric("Транспонированная матрица", C);
        float S = 0;
        for (int j = 0; j < C[0].length; j++) {
            float value = C[0][j];
            if (j % 2 == 0) {
                for (int i = 1; i < C.length; i++) {
                    if (C[i][j] > value) {
                        value = C[i][j];
                    }
                }
            } else {
                for (int i = 1; i < C.length; i++) {
                    if (C[i][j] < value) {
                        value = C[i][j];
                    }
                }
            }
            S += value;
        }
        System.out.println("Сумма = " + S);
    }
}

