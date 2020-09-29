import java.util.Random;

public class ArraysExceptions {

    private static String[][] myArray;
    private static int randomValue;
    static Random generator = new Random();
    private static int summ = 0;
    private static int indexI = 0;
    private static int indexJ = 0;


    public static void main(String[] args) {
        randomValue = generator.nextInt(5);
        myArray = new String[randomValue][randomValue];
        if (arraySize(myArray)) {
            takeArray(myArray);
        }
    }


    private static void takeArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = String.valueOf(i) + String.valueOf(j);
                }
            }
            array[2][3] += "abc";

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    indexI = i;
                    indexJ = j;//Возникла проблема в том, что если не добавлять в j-тый индекс 1, то exception выдает предыдущий элемент перед ошибочным
                    try {
                        summ += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Error at data! Indexes of error data: ", indexI, indexJ);
                    }
                    System.out.println("Current summ = " + summ);
                }
            }
            System.out.println("Array summ = " + summ);
    }

    private static boolean arraySize(String[][] array) throws MyArraySizeException {
        boolean result = false;
        if (array.length != 4) {
            result = false;
            throw new MyArraySizeException("Array Size not accepted (Size= " + randomValue + ")");
        }

        for (String[] row : array) {
            if (row.length != 4) {
                result = false;
                throw new MyArraySizeException("Array Size not accepted (Size= " + randomValue + ")");
            }
        }
        result = true;
        return result;
    }

}
