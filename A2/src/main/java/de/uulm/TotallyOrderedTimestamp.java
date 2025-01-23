package de.uulm;

import java.math.BigInteger;

public class TotallyOrderedTimestamp implements Comparable<TotallyOrderedTimestamp> {
    private final long timestamp;
    private final long PID;
    private final long counter;

    public TotallyOrderedTimestamp(long timestamp, long PID, long counter) {
        this.timestamp = timestamp;
        this.PID = PID;
        this.counter = counter;
    }

    @Override
    public int compareTo(TotallyOrderedTimestamp otherTimestamp) {
        if (this.timestamp != otherTimestamp.timestamp) {
            return Long.compare(this.timestamp, otherTimestamp.timestamp);
        }
        if (this.PID != otherTimestamp.PID) {
            return Long.compare(this.PID, otherTimestamp.PID);
        }
        return Long.compare(this.counter, otherTimestamp.counter);
    }

    public BigInteger asBigInteger() {
        return BigInteger.valueOf(timestamp)
                .shiftLeft(Long.SIZE)
                .or(BigInteger.valueOf(PID))
                .shiftLeft(Long.SIZE)
                .or(BigInteger.valueOf(counter));
    }

    public long getTimestamp() {
        return timestamp;
    }
}
