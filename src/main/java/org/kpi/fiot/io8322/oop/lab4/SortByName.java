package org.kpi.fiot.io8322.oop.lab4;

import java.util.Comparator;

/**
 * Сортировщик по названию
 */
public class SortByName implements Comparator<Kosmetika> {
    /**
     * Сортировка по названию
     * @param obj1 первый сравниваемый объект
     * @param obj2 второй сравниваемый объект
     * @return -1 - если название 1го объекта выше по алфавиту чем название второго, 0 - если название объектов совпадает, 1 - если название 1го объекта ниже по алфавиту чем название второго
     */
    @Override
    public int compare(Kosmetika obj1, Kosmetika obj2) {
        if (obj1.getName() == null && obj2.getName() == null) {
            return 0;
        } else if (obj1.getName() == null && obj2.getName() != null) {
            return 1;
        } else if (obj2.getName() == null && obj1.getName() != null) {
            return -1;
        } else {
            return obj1.getName().toLowerCase().compareTo(obj2.getName().toLowerCase());
        }
    }
}
