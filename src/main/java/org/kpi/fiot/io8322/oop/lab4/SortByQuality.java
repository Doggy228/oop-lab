package org.kpi.fiot.io8322.oop.lab4;

import java.util.Comparator;
/**
 * Сортировщик по качеству
 */
public class SortByQuality implements Comparator<Kosmetika> {
    /**
     * Сортировка по качеству
     * @param obj1 первый сравниваемый объект
     * @param obj2 второй сравниваемый объект
     * @return -1 - если качество 1го объекта меньше качества второго, 0 - если качество объектов совпадает, 1 -если качество 1го объекта больше качества второго,
     */
@Override
    public int compare(Kosmetika obj1, Kosmetika obj2) {
        return obj1.getQuality() - obj2.getQuality();
    }
}
