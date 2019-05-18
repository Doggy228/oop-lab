package org.kpi.fiot.io8322.oop.lab7;

import org.junit.Test;
import org.kpi.fiot.io8322.oop.lab6_2.Device;

import java.util.ListIterator;

import static org.junit.Assert.*;

public class DeviceListListIteratorTest {

    @Test
    public void hasNext() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        ListIterator<Device> listIterator = deviceList.listIterator(4);
        assertTrue(listIterator.hasNext());
        listIterator.next();
        assertTrue(listIterator.hasNext());
        listIterator.next();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void next() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        ListIterator<Device> listIterator = deviceList.listIterator();
        for(int i=0; i<arrDeviceStd.length; i++) {
            assertSame(arrDeviceStd[i], listIterator.next());
        }
    }

    @Test
    public void hasPrevious() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        ListIterator<Device> listIterator = deviceList.listIterator(2);
        assertTrue(listIterator.hasPrevious());
        listIterator.previous();
        assertTrue(listIterator.hasPrevious());
        listIterator.previous();
        assertFalse(listIterator.hasPrevious());
    }

    @Test
    public void previous() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        ListIterator<Device> listIterator = deviceList.listIterator(2);
        assertSame(arrDeviceStd[1], listIterator.previous());
        assertSame(arrDeviceStd[0], listIterator.previous());
    }

    @Test
    public void nextIndex() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        ListIterator<Device> listIterator = deviceList.listIterator(4);
        assertEquals(4, listIterator.nextIndex());
        listIterator.next();
        assertEquals(5, listIterator.nextIndex());
        listIterator.next();
        assertEquals(6, listIterator.nextIndex());
    }

    @Test
    public void previousIndex() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        ListIterator<Device> listIterator = deviceList.listIterator(2);
        assertEquals(1, listIterator.previousIndex());
        listIterator.previous();
        assertEquals(0, listIterator.previousIndex());
        listIterator.previous();
        assertEquals(-1, listIterator.previousIndex());
    }

    @Test
    public void remove() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        ListIterator<Device> listIterator = deviceList.listIterator();
        listIterator.next();
        listIterator.next();
        listIterator.remove();
        assertSame(arrDeviceStd[0], listIterator.previous());
        assertSame(arrDeviceStd[0], listIterator.next());
        assertSame(arrDeviceStd[2], listIterator.next());
    }

    @Test
    public void set() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        ListIterator<Device> listIterator = deviceList.listIterator();
        listIterator.next();
        Device device11 = new Device(11);
        listIterator.set(device11);
        assertSame(arrDeviceStd[0], listIterator.previous());
        assertSame(arrDeviceStd[0], listIterator.next());
        assertSame(device11, listIterator.next());
        assertSame(arrDeviceStd[2], listIterator.next());
    }

    @Test
    public void add() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        ListIterator<Device> listIterator = deviceList.listIterator();
        listIterator.next();
        Device device11 = new Device(11);
        listIterator.add(device11);
        assertSame(arrDeviceStd[0], listIterator.previous());
        assertSame(arrDeviceStd[0], listIterator.next());
        assertSame(device11, listIterator.next());
        assertSame(arrDeviceStd[1], listIterator.next());
        assertSame(arrDeviceStd[2], listIterator.next());
    }
}