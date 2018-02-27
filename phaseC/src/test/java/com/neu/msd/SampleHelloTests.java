package com.neu.msd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleHelloTests {
    @Test
    public void testAddNode() {
        SampleHello s = new SampleHello();
        assertEquals(s.hello(), "Hello World");
    }
}
