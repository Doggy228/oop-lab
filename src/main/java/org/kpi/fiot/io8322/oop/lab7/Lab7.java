package org.kpi.fiot.io8322.oop.lab7;

import org.kpi.fiot.io8322.oop.lab6_2.Device;
import org.kpi.fiot.io8322.oop.lab6_2.Lamp;
import org.kpi.fiot.io8322.oop.lab6_2.Microwave;
import org.kpi.fiot.io8322.oop.lab6_2.Tv;

public class Lab7 {
    private static void printList(String title, DeviceList deviceList) {
        System.out.println("==============================================================================================");
        System.out.println(title);
        System.out.println("----------------------------------------------------------------------------------------------");
        for (Device device : deviceList) {
            System.out.println("id: " + device.getId() + ", devType: " + device.getDevType() + ", name: " + device.getName());
        }
        System.out.println("==============================================================================================");
        System.out.println();
    }

    public static void main(String argc[]) {
        DeviceList deviceList = new DeviceList();
        deviceList.add(new Microwave(1, 900, false, 46664, "LG MW-1245"));
        deviceList.add(new Tv(2, 45, false, 44, "Samsung UE-4500"));
        DeviceList deviceList2 = new DeviceList(deviceList);
        printList("Test added", deviceList);
        System.out.println("Test contains success: " + deviceList.contains(new Device(2)));
        System.out.println("Test contains failed: " + deviceList.contains(new Device(2222)));
        System.out.println("Test get[1]: " + deviceList.get(1));
        for (int i = 0; i < 20; i++) {
            deviceList.add(new Lamp(1001 + i, 100, false, 12, "Lamp #" + (i + 1), 1));
        }
        printList("Test expand internal array", deviceList);
        deviceList.retainAll(deviceList2);
        printList("Test retainAll and squeeze internal array", deviceList);
        deviceList.remove(0);
        printList("Test remove 0 element", deviceList);
    }
}
