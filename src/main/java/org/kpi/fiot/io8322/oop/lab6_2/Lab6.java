package org.kpi.fiot.io8322.oop.lab6_2;

public class Lab6 {
    public static void printDevices(Device[] arr, String title){
        System.out.println("*****************************************************************************************");
        System.out.println(title);
        System.out.println("-----------------------------------------------------------------------------------------");
        for(Device element: arr){
            System.out.println(element);
        }
        System.out.println("*****************************************************************************************");
    }

    public static void main(String[] args) {
        DeviceGroup deviceGroup = new DeviceGroup();
        deviceGroup.add(new Lamp(1, 300, false, 345, "Люстра", 3));
        deviceGroup.add(new Lamp(2, 3, false, 4, "Ночник", 1));
        deviceGroup.add(new Lamp(3, 12, false, 12, "Подсветка", 2));
        deviceGroup.add(new Tv(4, 45, false, 56, "Samsung UX-4267"));
        deviceGroup.add(new Tv(5, 60, false, 77, "LG UE-5508"));
        deviceGroup.add(new Microwave(6, 800, false, 2900, "Samsung MW-45"));
        deviceGroup.getDevice(1).setEnabled(true);
        deviceGroup.getDevice(4).setEnabled(true);
        deviceGroup.getDevice(6).setEnabled(true);
        printDevices(deviceGroup.getSortedByPower(), "Відсортовані по потужності електроприлади");
        printDevices(deviceGroup.getOnlyEnabled(), "Список ввімкнених приладів");
        System.out.println("Загальна потужність ввімкнених приладів: "+deviceGroup.getTotalPowerEnabled()+" Вт");
        printDevices(deviceGroup.findDeviceByElectroRad(10,100), "Діапазон електро-магнітного випромінювання 10..100");
    }
}
