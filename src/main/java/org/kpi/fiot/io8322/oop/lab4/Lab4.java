package org.kpi.fiot.io8322.oop.lab4;

import java.util.Arrays;
import java.util.Collections;

/**
 * Лабараторная работа №4
 * Вариант №6
 */
public class Lab4 {
    /**
     * Вывод на экран отсортированого массива
     * @param title Заголовок
     * @param arr Массив
     */
    public static void printArray(String title, Kosmetika[] arr) {
        System.out.println(title);
        for (Kosmetika kosmetica : arr) {
            System.out.println(kosmetica);
        }
        System.out.println("*********************************");
    }

    /**
     * Исполнительный метод
     * @param args Параметры запуска программы
     */
    public static void main(String[] args) {
        Kosmetika[] arr = {new Kosmetika("Avon", "lipstick", 15, 6, "F"),
                new Kosmetika("Gillet", "shower gel", 20, 8, "M"),
                new Kosmetika("Avon", "perfume", 250, 6, "F"),
                new Kosmetika("Boss", "perfume", 300, 9, "M"),
        };
        Arrays.sort(arr, new SortByName());
        printArray("Сортировка по полю - название, по возрастанию", arr);
        Arrays.sort(arr, (new SortByType()));
        printArray("Сортировка по полю - тип, по возрастанию", arr);
        Arrays.sort(arr, Collections.reverseOrder(new SortByPrice()));
        printArray("Сортировка по полю - цена, по убыванию", arr);
        Arrays.sort(arr, Collections.reverseOrder(new SortByQuality()));
        printArray("Сортировка по полю - качество, по убыванию", arr);
        Arrays.sort(arr, new SortByGendUsed());
        printArray("Сортировка по полю - пол пользователя, по возрастанию", arr);
    }
}
