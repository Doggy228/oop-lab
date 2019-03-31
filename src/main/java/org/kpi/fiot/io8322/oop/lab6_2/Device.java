package org.kpi.fiot.io8322.oop.lab6_2;

public class Device {
    private int id;
    private String devType;
    private int power;
    private boolean enabled;
    private int electroRad;
    private String name;

    public Device(int id){
        this.id = id;
    }

    public Device(int id, String devType, int power, boolean enabled, int electroRad, String name) {
        this.id = id;
        this.devType = devType;
        this.power = power;
        this.enabled = enabled;
        this.electroRad = electroRad;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getElectroRad() {
        return electroRad;
    }

    public void setElectroRad(int electroRad) {
        this.electroRad = electroRad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Device device = (Device) o;
        return id == device.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + id + ", type: " + devType + ", name: " + name + " ,enabled = " + enabled + ", electroRad: " + electroRad + ", power: " + power;
    }

}

