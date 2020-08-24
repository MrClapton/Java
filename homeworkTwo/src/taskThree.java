import java.util.Arrays;

public class taskThree {
    public static void main(String[] args) {
        int[] givenArray = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(givenArray));

        multiplicationBy2(givenArray);
    }

    private static void multiplicationBy2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        System.out.println(Arrays.toString(array)); //[2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2]
    }
}
