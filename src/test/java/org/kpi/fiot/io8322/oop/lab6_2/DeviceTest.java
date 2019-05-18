package org.kpi.fiot.io8322.oop.lab6_2;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceTest {

    @Test
    public void getId() {
        Tv device = new Tv(1, 45, false, 56, "Samsung UX-4267");
        assertEquals(1, device.getId());
    }

    @Test
    public void setId() {
        Tv device = new Tv(1, 45, false, 56, "Samsung UX-4267");
        device.setId(2);
        assertEquals(2, device.getId());
    }

    @Test
    public void getDevType() {
        Tv device = new Tv(1,45, false, 56, "Samsung UX-4267");
        assertEquals("tv", device.getDevType());
    }

    @Test
    public void getPower() {
        Tv device = new Tv(1, 45, false, 56, "Samsung UX-4267");
        assertEquals(45, device.getPower());
    }

    @Test
    public void setPower() {
        Tv device = new Tv(1,45, false, 56, "Samsung UX-4267");
        device.setPower(35);
        assertEquals(35, device.getPower());
    }

    @Test
    public void isEnabled() {
        Tv device = new Tv(1, 45, false, 56, "Samsung UX-4267");
        assertEquals(false, device.isEnabled());
    }

    @Test
    public void setEnabled() {
        Tv device = new Tv(1,  45, false, 56, "Samsung UX-4267");
        device.setEnabled(true);
        assertEquals(true, device.isEnabled());
    }

    @Test
    public void getElectroRad() {
        Tv device = new Tv(1,  45, false, 56, "Samsung UX-4267");
        assertEquals(56, device.getElectroRad());
    }

    @Test
    public void setElectroRad() {
        Tv device = new Tv(1,  45, false, 56, "Samsung UX-4267");
        device.setElectroRad(43);
        assertEquals(43, device.getElectroRad());
    }

    @Test
    public void getName() {
        Tv device = new Tv(1, 45, false, 56, "Samsung UX-4267");
        assertEquals("Samsung UX-4267", device.getName());
    }

    @Test
    public void setName() {
        Tv device = new Tv(1,  45, false, 56, "Samsung UX-4267");
        device.setName("Lg G-344");
        assertEquals("Lg G-344", device.getName());
    }

    @Test
    public void testEquals() {
        Tv device = new Tv(1, 45, false, 56, "Samsung UX-4267");
        Device device1 = new Device(1);
        assertEquals(true, device.equals(device1));
        Device device2 = new Device(2);
        assertEquals(false, device.equals(device2));
    }


    @Test
    public void testHashCode() {
        Device device = new Device(1);
        Device device1 = new Device(1);
        assertEquals(device1.hashCode(), device.hashCode());
        Device device2 = new Device(2);
        assertNotEquals(device2.hashCode(), device.hashCode());
    }

    @Test
    public void testToString() {
        Tv device = new Tv(1, 45, false, 56, "Samsung UX-4267");
        assertEquals("id: 1, type: tv, name: Samsung UX-4267 ,enabled = false, electroRad: 56, power: 45", device.toString());
    }

    @Test
    public void testBadParamException() {
        try {
            new Device(-1);
            fail("Should have thrown an BadParamDeviceException");
        } catch (BadParamDeviceException e) {
            assertThat(e.getMessage(), CoreMatchers.containsString("field #id"));
        }
        try {
            new Tv(1, 0, false, 56, "Samsung UX-4267");
            fail("Should have thrown an BadParamDeviceException");
        } catch (BadParamDeviceException e) {
            assertThat(e.getMessage(), CoreMatchers.containsString("field #power"));
        }
        try {
            new Tv(1, 40, false, 0, "Samsung UX-4267");
            fail("Should have thrown an BadParamDeviceException");
        } catch (BadParamDeviceException e) {
            assertThat(e.getMessage(), CoreMatchers.containsString("field #electroRad"));
        }
        try {
            new Tv(1, 40, false, 56, "");
            fail("Should have thrown an BadParamDeviceException");
        } catch (BadParamDeviceException e) {
            assertThat(e.getMessage(), CoreMatchers.containsString("field #name"));
        }
        try {
            new Lamp(1, 40, false, 56, "Philips", 0);
            fail("Should have thrown an BadParamDeviceException");
        } catch (BadParamDeviceException e) {
            assertThat(e.getMessage(), CoreMatchers.containsString("field #countBulb"));
        }
    }
}