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

    public static void main(String[] argc) {
        float[][] B =  {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9}};
        System.out.println("Начальная матрица");
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
        float buf;
        for (int i = 0; i < B.length - 1; i++) {
            for (int j = i + 1; j < B[i].length; j++) {
                buf = B[i][j];
                B[i][j] = B[j][i];
                B[j][i] = buf;
            }}
        System.out.println("*****************");
        System.out.println("Транспонованая матрица");
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
        float min;
        long S = 0;
        for (int j = 0; j < B[0].length; j += 2) {
            min = B[0][j];
            for (int i = 1; i < B.length; i++) {
                if (min < B[i][j]) {
                    min = B[i][j];
                }
            }
            S += min;
        }
        float max;
        for (int j = 1; j < B[0].length; j += 2) {
            max = B[0][j];
            for (int i = 1; i < B.length; i++) {
                if (max > B[i][j]) {
                    max = B[i][j];
                }
            }
            S += max;
        }
        System.out.println("*****************");
        System.out.println("Сумма = "+ S);



    }
}

