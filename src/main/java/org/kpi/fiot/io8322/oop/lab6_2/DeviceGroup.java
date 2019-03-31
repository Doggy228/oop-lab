package org.kpi.fiot.io8322.oop.lab6_2;

import java.util.*;

public class DeviceGroup {
    Map<Device, Device> elements;

    public DeviceGroup() {
        elements = new HashMap<>();
    }

    public void add(Device element) {
        if (element != null) {
            elements.put(element,element);
        }
    }

    public void remove(Device element) {
        if (element != null) {
            elements.remove(element);
        }
    }

    public void remove(int deviceId) {
        elements.remove(new Device(deviceId));
    }

    public Device getDevice(int deviceId){
        return elements.get(new Device(deviceId));
    }

    public int getTotalPowerEnabled() {
        int power = 0;
        for (Device element : elements.values()) {
            if (element.isEnabled()) {
                power += element.getPower();
            }
        }
        return power;
    }

    public Device[] getSortedByPower() {
        Device[] arr = elements.values().toArray(new Device[0]);
        Arrays.sort(arr, new Comparator<Device>() {
            @Override
            public int compare(Device i1, Device i2) {
                return i1.getPower() - i2.getPower();
            }
        });
        return arr;
    }

    public Device[] getOnlyEnabled() {
        List<Device> list = new ArrayList<>();
        for(Device element: elements.values()){
            if(element.isEnabled()){
                list.add(element);
            }
        }
        return list.toArray(new Device[0]);
    }


    public Device[] findDeviceByElectroRad(int minValue, int maxValue) {
        List<Device> list = new ArrayList<>();
        for (Device element : elements.values()) {
            if (element.getElectroRad() >= minValue && element.getElectroRad() <= maxValue) {
                list.add(element);
            }
        }
        return list.toArray(new Device[0]);
    }
}
