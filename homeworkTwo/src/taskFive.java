import java.util.Arrays;

public class taskFive {

    public static void main(String[] args) {

        int[] createdArray = new int[10];

        for (int i = 0; i < createdArray.length; i++) {
            createdArray[i] = (int) (Math.random() * 200 - 100);
        }

        System.out.println(Arrays.toString(createdArray));

        searchForExtrema(createdArray);
    }

    private static void searchForExtrema(int[] createdArray) {

        int max = createdArray[0], min = createdArray[0];

        for(int i = 1; i < createdArray.length; i++) {
            if (createdArray[i] < min) min = createdArray[i];
        }

        for (int i = 0; i< createdArray.length; i++) {
            if (createdArray[i] > max) max = createdArray[i];
        }

        System.out.println("Min element = " + min + ", Max element = " + max);
    }

}
