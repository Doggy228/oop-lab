package org.kpi.fiot.io8322.oop.lab4;

import java.util.Comparator;

/**
 * Сортировщик по полу пользователя
 */
public class SortByGendUsed implements Comparator<Kosmetika> {
    /**
     * Сортировка по полу пользователя
     * @param obj1 первый сравниваемый объект
     * @param obj2 второй сравниваемый объект
     * @return -1 - если пол 1го объекта выше по алфавиту чем пол второго, 0 - если пол объектов совпадает, 1 - если пол 1го объекта ниже по алфавиту чем пол второго
     */
    @Override
    public int compare(Kosmetika obj1, Kosmetika obj2) {
        if (obj1.getGendUsed() == null && obj2.getGendUsed() == null) {
            return 0;
        } else if (obj1.getGendUsed() == null && obj2.getGendUsed() != null) {
            return 1;
        } else if (obj2.getGendUsed() == null && obj1.getGendUsed() != null) {
            return -1;
        } else {
            return obj1.getGendUsed().toLowerCase().compareTo(obj2.getGendUsed().toLowerCase());
        }
    }
}
