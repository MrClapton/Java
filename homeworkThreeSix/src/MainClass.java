import java.util.Arrays;

public class MainClass {

    public static int[] countElemAfterFour(int[] array) {
        for (int i = array.length - 1; i > -1; i--) {
            if (array[i] == 4 && i < array.length - 1) {
                return Arrays.copyOfRange(array, i + 1, array.length);
            } else if (array[i] == 4) {
                return new int[0];
            }
        }
        throw new RuntimeException("Массив не содержит четверок");
    }

    public static boolean findOneAndFour(int[] array) {
        boolean oneFound = false;
        boolean fourFound = false;
        for (int e : array) {
            if (e == 1) {
                oneFound = true;
            }
            else if (e == 4) {
                fourFound = true;
            }
            if (oneFound && fourFound) return true;
        }
        return false;
    }

}
