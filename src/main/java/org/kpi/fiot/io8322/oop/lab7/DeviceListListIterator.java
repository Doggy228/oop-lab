package org.kpi.fiot.io8322.oop.lab7;

import org.kpi.fiot.io8322.oop.lab6_2.Device;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DeviceListListIterator implements ListIterator<Device> {
    private DeviceList deviceList;
    private int index;
    private int oldIndex;

    public DeviceListListIterator(DeviceList deviceList) {
        this(deviceList, 0);
    }

    public DeviceListListIterator(DeviceList deviceList, int index) {
        this.deviceList = deviceList;
        this.index = index;
        this.oldIndex = -1;
    }

    @Override
    public boolean hasNext() {
        return index < deviceList.size();
    }

    @Override
    public Device next() {
        if (index < deviceList.size()) {
            oldIndex = index;
            index++;
            return deviceList.get(index - 1);
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasPrevious() {
        return index != 0;
    }

    @Override
    public Device previous() {
        if (index > 0) {
            oldIndex = index;
            index--;
            return deviceList.get(index);
        }
        throw new NoSuchElementException();
    }

    @Override
    public int nextIndex() {
        return index;
    }

    @Override
    public int previousIndex() {
        return index - 1;
    }

    @Override
    public void remove() {
        if(oldIndex<0) throw new IllegalStateException();
        deviceList.remove(oldIndex);
        if(index>oldIndex) index--;
        oldIndex = -1;
    }

    @Override
    public void set(Device device) {
        deviceList.set(index, device);
    }

    @Override
    public void add(Device device) {
        deviceList.add(index, device);
    }
}
