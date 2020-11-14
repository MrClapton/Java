import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

public class Test {
    private static int [][][]  testArray;
    private static boolean[] checkRes;

    @BeforeAll
    public static void init() {
        testArray = new int[][][] {
                {{1, 7}, {1, 2, 4, 4, 2, 3, 4, 1, 7}},
                        {{}, {1, 1, 1, 1, 1, 1, 1, 4}},
                        {{2, 1, 1, 1}, {4, 2, 1, 3, 4, 2, 1, 1, 1}},
                        {{3, 2}, {5, 4, 3, 2}},
                        {{}, {5, 1, 2, 3, 1, 2, 0}},
                        {{}, {}}
        };
        checkRes = new boolean[] {true, true, true, false, false, false};
    }

    @org.junit.jupiter.api.Test
    public void countElemAfterFour() {
        for (int i = 0; i < testArray.length - 2; i++) {
            Assertions.assertArrayEquals(testArray[i][0], MainClass.countElemAfterFour(testArray[i][1]));
        }
        for (int i = testArray.length - 2; i < testArray.length; i++) {
            int index = i;
            Assertions.assertThrows(RuntimeException.class, () -> MainClass.countElemAfterFour(testArray[index][1]));
        }
    }

    @org.junit.jupiter.api.Test
    public void findOneAndFour() {
        for (int i = 0; i < testArray.length; i++) {
            Assertions.assertEquals(checkRes[i], MainClass.findOneAndFour(testArray[i][1]));
        }
    }

}

