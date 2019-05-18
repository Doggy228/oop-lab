package org.kpi.fiot.io8322.oop.lab6_2;

import org.junit.Test;

import static org.junit.Assert.*;

public class LampTest {

    @Test
    public void getCountBulb() {
        Lamp device = new Lamp(1, 45, false, 56, "Philips", 5);
        assertEquals(5, device.getCountBulb());
    }

    @Test
    public void setCountBulb() {
        Lamp device = new Lamp(1, 45, false, 56, "Philips", 5);
        device.setCountBulb(10);
        assertEquals(10, device.getCountBulb());
    }

    @Test
    public void testToString() {
        Lamp device = new Lamp(1, 45, false, 56, "Philips", 5);
        assertEquals("id: 1, type: lamp, name: Philips ,enabled = false, electroRad: 56, power: 45, countBulb: 5", device.toString());
    }
}