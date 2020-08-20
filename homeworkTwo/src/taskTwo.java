import java.util.Arrays;

public class taskTwo {
    public static void main(String[] args) {
        int[] eightArray = new int[8];
        System.out.println(Arrays.toString(eightArray));
            for (int i = 1; i < eightArray.length; i++) {
                eightArray[i] += eightArray[i-1] + 3;
            }
        System.out.println(Arrays.toString(eightArray)); //[0, 3, 6, 9, 12, 15, 18, 21]
    }
}
