package com.tmstmp;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void mult_isCorrect() throws Exception {
        assertEquals(4, 2 * 2);
    }
    @Test
    public void division_isCorrect() throws Exception {
        assertEquals(3, 15 / 5);
    }
    @Test
    public void zerro_isCorrect() throws Exception {
        assertEquals(0, 0);
    }
    @Test
    public void one_isCorrect() throws Exception {
        assertEquals(1, 1);
    }
}
