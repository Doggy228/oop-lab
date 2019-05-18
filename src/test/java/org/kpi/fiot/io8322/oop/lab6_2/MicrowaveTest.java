package org.kpi.fiot.io8322.oop.lab6_2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MicrowaveTest {
    @Test
    public void testConstructor() {
        Microwave device = new Microwave(1, 450, false, 5006, "Samsung MW-45");
        assertEquals("microwave", device.getDevType());
    }
}