package org.example;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class PicCalculationTask implements Runnable {
    private long numPoints;
    private AtomicLong insideCircle;
    private Random random;

    public PicCalculationTask(long numPoints, AtomicLong insideCircle) {
        this.numPoints = numPoints;
        this.insideCircle = insideCircle;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (long i = 0; i < numPoints; i++) {
            double x = random.nextDouble() * 2 - 1;
            double y = random.nextDouble() * 2 - 1;

            if (x * x + y * y <= 1) {
                insideCircle.incrementAndGet();
            }
        }
    }
}