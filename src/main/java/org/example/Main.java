package org.example;

public class Main {
    public static void main(String[] args) {
        long numPoints = 10_000_000_000L;
        int numTasks = 8;

        ApproxPi approxPi = new ApproxPi(numPoints, numTasks);
        approxPi.calculate();
    }
}