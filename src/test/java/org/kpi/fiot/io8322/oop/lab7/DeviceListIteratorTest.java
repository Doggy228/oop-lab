package org.kpi.fiot.io8322.oop.lab7;

import org.junit.Test;
import org.kpi.fiot.io8322.oop.lab6_2.Device;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DeviceListIteratorTest {

    @Test
    public void hasNext() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[3];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        Iterator<Device> iterator = deviceList.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void next() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[3];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        Iterator<Device> iterator = deviceList.iterator();
        assertSame(arrDeviceStd[0], iterator.next());
        assertSame(arrDeviceStd[1], iterator.next());
        assertSame(arrDeviceStd[2], iterator.next());
    }
}