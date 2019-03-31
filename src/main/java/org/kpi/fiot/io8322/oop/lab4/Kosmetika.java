package org.kpi.fiot.io8322.oop.lab4;

/**
 * Класс описывающий косметический продукт,
 * который включает в себя: название, тип, цену, качество, пол пользователя
 */
public class Kosmetika {
    private String name;
    private String type;
    private int price;
    private int quality;
    private String gendUsed;

    /**
     * Конструктор класса
     * @param name Название
     * @param type Тип
     * @param price Цена
     * @param quality Качество
     * @param gendUsed Пол пользователя
     */
    public Kosmetika(String name, String type, int price, int quality, String gendUsed) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quality = quality;
        this.gendUsed = gendUsed;
    }

    /**
     * Получить текстовое представление объекта
     *
     * @return текстовое представление объекта
     */
    @Override
    public String toString() {
        return ("name: " + getName() + " ," + "type: " + getType() + " ," + "price: " + getPrice() + " ," + "quality: " + getQuality() + " ," + "gendUsed " + getGendUsed());
    }

    /**
     * Получить стоимость
     *
     * @return стоимость в копейках
     */
    public int getPrice() {
        return price;
    }

    /**
     * Получить качество
     *
     * @return оценка качества
     */
    public int getQuality() {
        return quality;
    }

    /**
     * Получить название
     *
     * @return название
     */
    public String getName() {
        return name;
    }

    /**
     * Получить пол пользователя
     *
     * @return пол пользователя
     */
    public String getGendUsed() {
        return gendUsed;
    }

    /**
     * Получить тип продукта
     *
     * @return тип продукта
     */
    public String getType() {
        return type;
    }
}



