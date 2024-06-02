import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        pintThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(compareSum(6,12));
        compareWithZero(-45);
        System.out.println(definitionNegative(-4));
        printString( "Hello",6);
        System.out.println(leapYear(2024));
        replacementZeroOne();
        fillingArray();
        ifLessSixMultipladeTwo();
        fillingDiagonal();
        fillingArray(10,6);

        }
        // 1
        public static void pintThreeWords() {
            System.out.println("Orange");
            System.out.println("Banana");
            System.out.println("Apple");
        }
        // 2
        public static void checkSumSign() {
            int a = 653;
            int b = 754;
            if ((a + b) >= 0)
                System.out.println("Сумма положительная");
            else
                System.out.println("Сумма отрицательная");
        }
        // 3
        public static void printColor() {
            int value = 65;
            if (value <= 0) {
                System.out.println("Красный");
            } else if (value <= 100) {
                System.out.println("Желтый");
            } else {
                System.out.println("Зелёный");
            }
        }
        // 4
        public static void compareNumbers() {
            int a = 67;
            int b = -76;
            if (a >= b)
                System.out.println("a >= b");
            else
                System.out.println("a < b");
        }
        // 5
        public static boolean compareSum(int a, int b) {
            int sum = a + b;
            return (sum >= 10 && sum <= 20);
        }
        // 6
        public static void compareWithZero(int a) {
            boolean Positive = a >= 0;
            if (Positive) {
                System.out.println("Положительное");
            } else {
                System.out.println("Отрицательное");
            }
        }
        // 7
        public static boolean definitionNegative(int a) {
            return a < 0;
        }
        // 8
        public static void printString(String line, int n) {
            for (int i = 0; i < n; i++) {
                System.out.println(line);
            }
        }
        //9
        public static boolean leapYear(int year) {
            boolean leap = true;
            if (year % 400 == 0) {
                return leap;
            }else if (year % 100 == 0) {
                leap = false;
                return leap;
            }else if (year % 4 == 0) {
                return leap;
            }else
                leap = false;
                return leap;
        }
        //10
        public static void replacementZeroOne() {
            int[] Array = {0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0};
            for (int i = 0; i < Array.length; i++) {
                if (Array[i] == 0) {
                    Array[i] = 1;
                } else
                    Array[i] = 0;
            }
            System.out.println(Arrays.toString(Array));
        }
        //11
        public static void fillingArray() {
            int[] Array = new int[100];
            for (int i = 0; i < Array.length; i++) {
                Array[i] = i+1;
            }
            System.out.println(Arrays.toString(Array));
        }
        //12
        public static void ifLessSixMultipladeTwo() {
            int[] Array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for (int i = 0; i < Array.length; i++) {
                if (Array[i] < 6) {
                    Array[i] = Array[i] * 2;
                }
            }
            System.out.println(Arrays.toString(Array));
        }
        //13
        public static void fillingDiagonal() {
            int[][] Array = new int[10][10];
            int n = 0;
            for (int i = 0; i < Array.length; i++) {
                Array[i][i] = 1;
            }
            for (int i = Array.length-1; i >= 0; i--) {
                Array[i][n] = 1;
                n++;
            }
            for (int i=0; i < Array.length; i++) {
                System.out.println(Arrays.toString(Array[i]));
            }
        }
        //14
        public static void fillingArray(int len, int initialValue) {
            int[] Array = new int[len];
            Arrays.fill(Array, initialValue);
            System.out.println(Arrays.toString(Array));
        }
    }