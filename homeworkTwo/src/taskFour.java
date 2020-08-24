import java.util.Arrays;

public class taskFour {
    public static void main(String[] args) {
        int[][] myTwoDimensionalArray = {
                {5, 10, 15, 20},
                {3, 6, 9, 12},
                {7, 14, 21, 28},
                {2, 4, 6, 8}
        };

        previewArray(myTwoDimensionalArray);
        diagonalUnits(myTwoDimensionalArray);
    }

    private static void previewArray(int[][] twoDimensionalArray) {
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                System.out.print(twoDimensionalArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    private static void diagonalUnits(int[][] twoDimensionalArray) {
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
               if (i == j) {
                   twoDimensionalArray[i][j] = 1;
               }
                System.out.print(twoDimensionalArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}

//        5 10 15 20
//        3 6 9 12
//        7 14 21 28
//        2 4 6 8
//        -----------
//        1 10 15 20
//        3 1 9 12
//        7 14 1 28
//        2 4 6 1