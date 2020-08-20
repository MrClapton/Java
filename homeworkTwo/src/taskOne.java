import java.util.Arrays;

public class taskOne {
    public static void main(String[] args) {
        int[] createdArray = {0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0};
        System.out.println(Arrays.toString(createdArray)); //[0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0]

        for (int i = 0; i < createdArray.length; i++) {
            if (createdArray[i] == 0) {
                createdArray[i] = 1;
            } else {
                createdArray[i] = 0;
            }
        }
        System.out.println(Arrays.toString(createdArray)); //[1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1]
    }
}
