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
        takeArray(myArray);
    }


    private static void takeArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length == 4) {
            System.out.println("Array Size accepted! (Size=4)");
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = String.valueOf(i) + String.valueOf(j);
                }
            }
            array[2][3] += "abc";

            try {
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array.length; j++) {
                        summ += Integer.parseInt(array[i][j]);
                        System.out.println("Current summ = " + summ);
                        indexI = i;
                        indexJ = j + 1;//Возникла проблема в том, что если не добавлять в j-тый индекс 1, то exception выдает предыдущий элемент перед ошибочным
                    }
                }
            } catch (NumberFormatException e) {
                throw new MyArrayDataException("Error at data! Indexes of error data: ", indexI, indexJ);
            }
            System.out.println("Array summ = " + summ);
        } else {
            throw new MyArraySizeException("Array Size not accepted (Size= " + randomValue + ")");
        }
    }
}
