package org.kpi.fiot.io8322.oop.lab6_2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DeviceGroupTest {

    @Test
    public void add() {
        DeviceGroup deviceGroup = new DeviceGroup();
        Device device1 = new Device(1);
        Device device2 = new Device(2);
        deviceGroup.add(device1);
        deviceGroup.add(device2);
        assertEquals(true, deviceGroup.getDevice(1).equals(device1));
        assertEquals(true, deviceGroup.getDevice(2).equals(device2));
        assertNull(deviceGroup.getDevice(3));
    }

    @Test
    public void removeById() {
        DeviceGroup deviceGroup = new DeviceGroup();
        Device device1 = new Device(1);
        Device device2 = new Device(2);
        deviceGroup.add(device1);
        deviceGroup.add(device2);
        deviceGroup.remove(1);
        assertNull(deviceGroup.getDevice(1));
        assertEquals(true, deviceGroup.getDevice(2).equals(device2));
    }

    @Test
    public void removeByObject() {
        DeviceGroup deviceGroup = new DeviceGroup();
        Device device1 = new Device(1);
        Device device2 = new Device(2);
        deviceGroup.add(device1);
        deviceGroup.add(device2);
        deviceGroup.remove(device1);
        assertNull(deviceGroup.getDevice(1));
        assertEquals(true, deviceGroup.getDevice(2).equals(device2));
    }

    @Test
    public void getDevice() {
        DeviceGroup deviceGroup = new DeviceGroup();
        Device device1 = new Device(1);
        Device device2 = new Device(2);
        deviceGroup.add(device1);
        deviceGroup.add(device2);
        assertEquals(true, deviceGroup.getDevice(1).equals(device1));
        assertEquals(true, deviceGroup.getDevice(2).equals(device2));
        assertNull(deviceGroup.getDevice(3));
    }

    @Test
    public void getTotalPowerEnabled() {
        DeviceGroup deviceGroup = new DeviceGroup();
        deviceGroup.add(new Tv(1,45, false, 56, "tv"));
        deviceGroup.add(new Tv(2,100, true, 56, "tv"));
        deviceGroup.add(new Tv(3,200, true, 56, "tv"));
        deviceGroup.add(new Tv(4,450, false, 56, "tv"));
        assertEquals(300, deviceGroup.getTotalPowerEnabled());
    }

    @Test
    public void getSortedByPower() {
        DeviceGroup deviceGroup = new DeviceGroup();
        deviceGroup.add(new Tv(1,450, false, 56, "tv"));
        deviceGroup.add(new Tv(2,100, true, 56, "tv"));
        deviceGroup.add(new Tv(3,200, true, 56, "tv"));
        deviceGroup.add(new Tv(4,30, false, 56, "tv"));
        Device arrDev[] = deviceGroup.getSortedByPower();
        int arrId[] = new int[arrDev.length];
        for(int i=0;i<arrId.length;i++){
            arrId[i] = arrDev[i].getId();
        }
        assertArrayEquals(new int[]{4,2,3,1}, arrId);
    }

    @Test
    public void getOnlyEnabled() {
        DeviceGroup deviceGroup = new DeviceGroup();
        deviceGroup.add(new Tv(1,450, false, 56, "tv"));
        deviceGroup.add(new Tv(2,100, true, 56, "tv"));
        deviceGroup.add(new Tv(3,200, true, 56, "tv"));
        deviceGroup.add(new Tv(4,30, false, 56, "tv"));
        Device arrDev[] = deviceGroup.getOnlyEnabled();
        Map<Device, Device> mapDev = new HashMap<>();
        for(Device device: arrDev){
            mapDev.put(device, device);
        }
        assertNull(mapDev.get(new Device(1)));
        assertNotNull(mapDev.get(new Device(2)));
        assertNotNull(mapDev.get(new Device(3)));
        assertNull(mapDev.get(new Device(4)));
    }

    @Test
    public void findDeviceByElectroRad() {
        DeviceGroup deviceGroup = new DeviceGroup();
        deviceGroup.add(new Tv(1,450, false, 100, "tv"));
        deviceGroup.add(new Tv(2,100, true, 500, "tv"));
        deviceGroup.add(new Tv(3,200, true, 600, "tv"));
        deviceGroup.add(new Tv(4,30, false, 1000, "tv"));
        deviceGroup.add(new Tv(5,30, false, 2000, "tv"));
        Device arrDev[] = deviceGroup.findDeviceByElectroRad(500,1000);
        Map<Device, Device> mapDev = new HashMap<>();
        for(Device device: arrDev){
            mapDev.put(device, device);
        }
        assertNull(mapDev.get(new Device(1)));
        assertNotNull(mapDev.get(new Device(2)));
        assertNotNull(mapDev.get(new Device(3)));
        assertNotNull(mapDev.get(new Device(4)));
        assertNull(mapDev.get(new Device(5)));
    }
}