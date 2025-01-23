package de.uulm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotallyOrderedClockTest {

    private TotallyOrderedClock clock;

    @BeforeEach
    void setUp() {
        clock = new TotallyOrderedClock(5);
    }

    @Test
    void createTimestamp() {
        var a1 = clock.createTimestamp(150L);
        var a2 = clock.createTimestamp(150L);
        var b = clock.createTimestamp(150L);

        assertNotNull(a1);
        assertNotNull(a2);
        assertNotNull(b);

        assertEquals(a1.getTimestamp(), a2.getTimestamp());
        assertEquals(a1.getTimestamp(), b.getTimestamp());
        assertEquals(150L, a2.getTimestamp());
    }

    @Test
    void testCreateTimestamp() {
        var a = clock.createTimestamp();
        var b = clock.createTimestamp();

        assertNotNull(a);
        assertNotNull(b);
        assertNotEquals(a,b);
    }
}