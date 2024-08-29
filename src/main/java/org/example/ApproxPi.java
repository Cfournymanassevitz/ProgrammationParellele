package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class ApproxPi {
    private long numPoints;
    private int numTasks;

    public ApproxPi(long numPoints, int numTasks) {
        this.numPoints = numPoints;
        this.numTasks = numTasks;
    }

    public void calculate() {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(numTasks);
        List<Future<?>> futures = new ArrayList<>();
        AtomicLong insideCircle = new AtomicLong(0);

        long pointsPerTask = numPoints / numTasks;

        for (int i = 0; i < numTasks; i++) {
            PicCalculationTask task = new PicCalculationTask(pointsPerTask, insideCircle);
            futures.add(executor.submit(task));
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        double piApproximation = (4.0 * insideCircle.get()) / numPoints;
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Approximation de Pi = " + piApproximation);
        System.out.println("Temps d'exécution = " + elapsedTime / 1000.0 + " secondes");
    }
}