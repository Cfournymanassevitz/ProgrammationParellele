package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        long numPoints = 10_000_000_000L;  // 10 milliards de points

        ApproxPi approxPi = new ApproxPi(numPoints);
        approxPi.calculate();
    }
}