package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFactorial(9));
    }

    public static int getFactorial(int f) {
        if (f < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }

        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

}