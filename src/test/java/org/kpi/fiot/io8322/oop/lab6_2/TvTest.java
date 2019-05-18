package org.kpi.fiot.io8322.oop.lab6_2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TvTest {
    @Test
    public void testConstructor() {
        Tv device = new Tv(1, 45, false, 56, "Samsung UX-4267");
        assertEquals("tv", device.getDevType());
    }
}