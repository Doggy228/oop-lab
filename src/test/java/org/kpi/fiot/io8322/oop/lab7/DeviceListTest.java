package org.kpi.fiot.io8322.oop.lab7;

import org.junit.Test;
import org.kpi.fiot.io8322.oop.lab6_2.Device;
import org.kpi.fiot.io8322.oop.lab6_2.Tv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class DeviceListTest {
    private void testOrder(DeviceList deviceList, int[] arrId) {
        assertEquals(arrId.length, deviceList.size());
        int[] arrId2 = new int[arrId.length];
        for (int i = 0; i < arrId2.length; i++) {
            arrId2[i] = deviceList.get(i).getId();
        }
        assertArrayEquals(arrId, arrId2);
    }

    @Test
    public void size() {
        DeviceList deviceList = new DeviceList();
        assertEquals(0, deviceList.size());
        deviceList.add(new Device(1));
        assertEquals(1, deviceList.size());
        deviceList.add(new Device(2));
        assertEquals(2, deviceList.size());
    }

    @Test
    public void isEmpty() {
        DeviceList deviceList = new DeviceList();
        assertEquals(true, deviceList.isEmpty());
        deviceList.add(new Device(1));
        assertEquals(false, deviceList.isEmpty());
    }

    @Test
    public void contains() {
        DeviceList deviceList = new DeviceList();
        deviceList.add(new Device(1));
        deviceList.add(new Device(2));
        assertEquals(true, deviceList.contains(new Device(1)));
        assertEquals(false, deviceList.contains(new Device(3)));
    }

    @Test
    public void iterator() {
        DeviceList deviceList = new DeviceList();
        deviceList.add(new Device(1));
        deviceList.add(new Device(2));
        deviceList.add(new Device(3));
        int arrId[] = new int[deviceList.size()];
        int index = 0;
        Iterator<Device> it = deviceList.iterator();
        while (it.hasNext()) {
            arrId[index] = it.next().getId();
            index++;
        }
        assertArrayEquals(new int[]{1, 2, 3}, arrId);
    }

    @Test
    public void toArray() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[3];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        Object[] arrObj = deviceList.toArray();
        assertEquals(arrDeviceStd.length, arrObj.length);
        for (int i = 0; i < arrObj.length; i++) {
            assertSame(arrDeviceStd[i], arrObj[i]);
        }
    }

    @Test
    public void toArrayByType() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[3];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        Object[] arrObj = deviceList.toArray(new Device[0]);
        assertEquals(arrDeviceStd.length, arrObj.length);
        for (int i = 0; i < arrObj.length; i++) {
            assertSame(arrDeviceStd[i], arrObj[i]);
        }
    }

    @Test
    public void add() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[3];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        testOrder(deviceList, new int[]{1, 2, 3});
    }

    @Test
    public void removeByIndex() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[3];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        deviceList.remove(1);
        testOrder(deviceList, new int[]{1, 3});
    }

    @Test
    public void containsAll() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        List<Device> list1 = new ArrayList<>();
        list1.add(new Device(2));
        list1.add(new Device(4));
        list1.add(new Device(5));
        assertTrue(deviceList.containsAll(list1));
        list1.add(new Device(10));
        assertFalse(deviceList.containsAll(list1));
    }

    @Test
    public void addAll() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        List<Device> list1 = new ArrayList<>();
        list1.add(new Device(11));
        list1.add(new Device(12));
        list1.add(new Device(13));
        deviceList.addAll(list1);
        testOrder(deviceList, new int[]{1, 2, 3, 4, 5, 6, 11, 12, 13});
    }

    @Test
    public void addAllByIndex() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        List<Device> list1 = new ArrayList<>();
        list1.add(new Device(11));
        list1.add(new Device(12));
        list1.add(new Device(13));
        deviceList.addAll(2, list1);
        testOrder(deviceList, new int[]{1, 2, 11, 12, 13, 3, 4, 5, 6});
    }

    @Test
    public void removeAll() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        List<Device> list1 = new ArrayList<>();
        list1.add(new Device(2));
        list1.add(new Device(3));
        list1.add(new Device(11));
        deviceList.removeAll(list1);
        testOrder(deviceList, new int[]{1, 4, 5, 6});
    }

    @Test
    public void retainAll() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        List<Device> list1 = new ArrayList<>();
        list1.add(new Device(2));
        list1.add(new Device(3));
        list1.add(new Device(11));
        deviceList.retainAll(list1);
        testOrder(deviceList, new int[]{2, 3});
    }

    @Test
    public void clear() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        deviceList.clear();
        assertTrue(deviceList.isEmpty());
    }

    @Test
    public void get() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        assertSame(arrDeviceStd[2], deviceList.get(2));
    }

    @Test
    public void set() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        Device device11 = new Device(11);
        deviceList.set(2, device11);
        assertSame(device11, deviceList.get(2));
    }

    @Test
    public void addByIndex() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        deviceList.add(0, new Device(11));
        deviceList.add(3, new Device(12));
        deviceList.add(deviceList.size(), new Device(13));
        testOrder(deviceList, new int[]{11, 1, 2, 12, 3, 4, 5, 6, 13});
    }

    @Test
    public void removeByObject() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[3];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        deviceList.remove(new Device(2));
        testOrder(deviceList, new int[]{1, 3});
    }

    @Test
    public void indexOf() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        assertEquals(0, deviceList.indexOf(arrDeviceStd[0]));
        assertEquals(2, deviceList.indexOf(arrDeviceStd[2]));
        assertEquals(5, deviceList.indexOf(arrDeviceStd[5]));
        assertEquals(-1, deviceList.indexOf(new Device(20)));
    }

    @Test
    public void lastIndexOf() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        deviceList.add(arrDeviceStd[2]);
        deviceList.add(arrDeviceStd[4]);
        assertEquals(0, deviceList.lastIndexOf(arrDeviceStd[0]));
        assertEquals(1, deviceList.lastIndexOf(arrDeviceStd[1]));
        assertEquals(6, deviceList.lastIndexOf(arrDeviceStd[2]));
        assertEquals(7, deviceList.lastIndexOf(arrDeviceStd[4]));
        assertEquals(-1, deviceList.lastIndexOf(new Device(20)));
    }

    @Test
    public void listIterator() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        ListIterator<Device> listIterator = deviceList.listIterator();
        int[] arrId = new int[arrDeviceStd.length];
        for(int i=0;i<arrId.length;i++){
            arrId[i] = listIterator.next().getId();
        }
        assertArrayEquals(new int[]{1,2,3,4,5,6}, arrId);
    }

    @Test
    public void listIteratorByIndex() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        ListIterator<Device> listIterator = deviceList.listIterator(2);
        assertEquals(1, listIterator.previousIndex());
        listIterator.previous();
        listIterator.previous();
        int[] arrId = new int[arrDeviceStd.length];
        for(int i=0;i<arrId.length;i++){
            arrId[i] = listIterator.next().getId();
        }
        assertArrayEquals(new int[]{1,2,3,4,5,6}, arrId);
    }

    @Test
    public void subList() {
        DeviceList deviceList = new DeviceList();
        Device[] arrDeviceStd = new Device[6];
        for (int i = 0; i < arrDeviceStd.length; i++) {
            arrDeviceStd[i] = new Device(i + 1);
            deviceList.add(arrDeviceStd[i]);
        }
        List<Device> list1 = deviceList.subList(1, 4);
        int[] arrId = new int[list1.size()];
        for(int i=0;i<arrId.length;i++){
            arrId[i] = list1.get(i).getId();
        }
        assertArrayEquals(new int[]{2,3,4,5}, arrId);
    }
}