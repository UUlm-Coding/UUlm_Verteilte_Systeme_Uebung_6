package de.uulm;

import java.util.concurrent.atomic.AtomicLong;

public class TotallyOrderedClock {
    private final long PID;
    private final AtomicLong counter;

    public TotallyOrderedClock(long PID) {
        this.PID = PID;
        this.counter = new AtomicLong(0);
    }

    public TotallyOrderedTimestamp createTimestamp() {
        return createTimestamp(System.currentTimeMillis());
    }

    public TotallyOrderedTimestamp createTimestamp(long time) {
        if (time < PID) {
            throw new IllegalArgumentException("Time must be greater than PID");
        }
        long counterValue = counter.incrementAndGet();
        return new TotallyOrderedTimestamp(time, PID, counterValue);
    }
}
