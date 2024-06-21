public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(countArray());
        } catch (MyArraySizeException | MyArrayDataException e) {
        }

    }
    public static int countArray () throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        String[][] array = new String[][]{{"5", "3", "7", "2"}, {"3", "6", "8", "3"}, {"9", "9", "2", "5"}, {"7", "2", "8", "4"}};
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    count = count + Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }
}