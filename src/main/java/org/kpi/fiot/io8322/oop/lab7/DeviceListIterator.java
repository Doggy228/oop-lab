package org.kpi.fiot.io8322.oop.lab7;

import org.kpi.fiot.io8322.oop.lab6_2.Device;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DeviceListIterator implements Iterator<Device> {
    private DeviceList deviceList;
    private int index;
    public DeviceListIterator(DeviceList deviceList){
        this.deviceList = deviceList;
        index = 0;
    }
    @Override
    public boolean hasNext() {
        return index<deviceList.size();
    }

    @Override
    public Device next() {
        if(index<deviceList.size()){
            index++;
            return deviceList.get(index-1);
        }
        throw new NoSuchElementException();
    }
}
