package org.kpi.fiot.io8322.oop.lab4;

import java.util.Comparator;

/**
 * Сортировщик по цене
 */
public class SortByPrice implements Comparator<Kosmetika> {
    /**
     * Сортировка по цене
     * @param obj1 первый сравниваемый объект
     * @param obj2 второй сравниваемый объект
     * @return -1 - если цена 1го объекта меньше цены второго, 0 - если цены объектов совпадают, 1 -если цена 1го объекта больше цены второго
     */
    @Override
    public int compare(Kosmetika obj1, Kosmetika obj2) {
        return obj1.getPrice() - obj2.getPrice();
    }
}
