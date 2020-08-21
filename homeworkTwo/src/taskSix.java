import java.util.Arrays;

public class taskSix {
    public static void main(String[] args) {

        int[] createdArray = new int[5];

        for (int i = 0;i < createdArray.length; i++) {
            createdArray[i] = (int) (Math.random() * 10);
        }

        System.out.println(Arrays.toString(createdArray));

        System.out.println(comparisonOfParts(createdArray));
    }

    private static boolean comparisonOfParts(int[] createdArray) {

        int leftSum = 0, arraySum = 0;
        boolean res = false;

        for (int i = 0; i < createdArray.length; i++) {
            arraySum += createdArray[i];
        }
        System.out.println("Array sum = " + arraySum);

        for (int i = 0; i < createdArray.length-1; i++) {
            leftSum += createdArray[i];
            System.out.print("Current left sum = " + leftSum + " ");
            System.out.println("Current right sum = " + (arraySum - leftSum) + " ");
                if ((arraySum - leftSum) == leftSum) {
                    res = true;
                }
        }
        return res;
    }
}



//        [3, 5, 5, 8, 5]
//        Array sum = 26
//        Current left sum = 3 Current right sum = 23
//        Current left sum = 8 Current right sum = 18
//        Current left sum = 13 Current right sum = 13
//        Current left sum = 21 Current right sum = 5
//        true