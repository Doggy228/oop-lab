package org.kpi.fiot.io8322.oop.lab6_2;

public class Lamp extends Device {
    private int countBulb;

    public Lamp(int id, int power, boolean enabled, int electroRad, String name, int countBulb) {
        super(id, "lamp", power, enabled, electroRad, name);
        this.countBulb = countBulb;
    }

    public int getCountBulb() {
        return countBulb;
    }

    public void setCountBulb(int countBulb) {
        this.countBulb = countBulb;
    }

    @Override
    public String toString() {
        return "id: " + getId() + ", type: " + getDevType() + ", name: " + getName() + " ,enabled = " + isEnabled() + ", electroRad: " + getElectroRad() + ", power: " + getPower() + ", countBulb: " + countBulb;
    }
}
