package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFactorial(20));
    }

    public static long getFactorial(int f) {
        if (f < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }

        long result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
}