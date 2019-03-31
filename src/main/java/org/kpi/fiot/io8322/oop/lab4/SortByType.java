package org.kpi.fiot.io8322.oop.lab4;

import java.util.Comparator;

/**
 * Сортировщик по типу
 */
public class SortByType implements Comparator<Kosmetika> {
    /**
     *Сортировка по типу
     * @param obj1 первый сравниваемый объект
     * @param obj2 второй сравниваемый объект
     * @return -1 - если тип 1го объекта выше по алфавиту чем тип второго, 0 - если тип объектов совпадает, 1 - если тип 1го объекта выше по алфавиту чем тип второго
     */
    @Override
    public int compare(Kosmetika obj1, Kosmetika obj2) {
        if (obj1.getType() == null && obj2.getType() == null) {
            return 0;
        } else if (obj1.getType() == null && obj2.getType() != null) {
            return 1;
        } else if (obj2.getType() == null && obj1.getType() != null) {
            return -1;
        } else {
            return obj1.getType().toLowerCase().compareTo(obj2.getType().toLowerCase());
        }
    }
}
