package org.example;

import java.util.Random;

public class ApproxPi {
    private long numPoints;
    private long insideCircle;
    private Random random;

    public ApproxPi(long numPoints) {
        this.numPoints = numPoints;
        this.insideCircle = 0;
        this.random = new Random();
    }

    public void calculate() {
        long startTime = System.currentTimeMillis();

        for (long i = 0; i < numPoints; i++) {
            double x = random.nextDouble() * 2 - 1; // Génère un nombre entre -1 et 1
            double y = random.nextDouble() * 2 - 1; // Génère un nombre entre -1 et 1

            if (x * x + y * y <= 1) {
                insideCircle++;
            }
        }

        double piApproximation = (4.0 * insideCircle) / numPoints;
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Approximation de Pi = " + piApproximation);
        System.out.println("Temps d'exécution = " + elapsedTime / 1000.0 + " secondes");
    }
}
