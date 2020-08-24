import java.util.Arrays;
import java.util.Scanner;

public class taskSeven {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число n - значение сдвигов типа int и count - количество элементов массива");
        int n = scanner.nextInt();
        int count = scanner.nextInt();
        int[] createdArray = new int[count];

        for(int i = 0; i < count; i++) {
            createdArray[i] = (int)(Math.random()*10);
        }

        System.out.println("Созданный массив --> " + Arrays.toString(createdArray));
        System.out.println();

        cyclicalDisplacement(createdArray, n);
    }

    private static void cyclicalDisplacement(int[] createdArray, int displacementCount) {
        if (displacementCount != 0) {   //в первую очередь проверяем, что заданное число для смещения отлично от 0, если условие верное, то вся магия внутри ;)

            //далее нужно провести сравнение переданного числа n и длины массива, в случае если n больше, тогда в смещение передается остаток от деления n на длину массива (!) по модулю
            int displacementCountOutcome;

            if (displacementCount > createdArray.length) {
                displacementCountOutcome = Math.abs(displacementCount % createdArray.length);
            } else {
                displacementCountOutcome = displacementCount;
            }
            //далее рассмотрим 2 возможных варианта: когда shift > 0 и когда shift < 0

            if (displacementCountOutcome > 0) {
                for (int i = 0; i < displacementCountOutcome; i++) {                         //в цикле все элементы будут смещаться на 1 вправо, но при этом на каждой итерации нужно перемещать последний элемент на место первого, а нулевой элемент на [1] индекс
                    int zeroElement = createdArray[0];
                    createdArray[0] = createdArray[createdArray.length - 1];
                        for (int j = 1; j < createdArray.length - 1; j++) {
                            createdArray[createdArray.length-j] = createdArray[createdArray.length-j-1];
                        }
                        createdArray[1] = zeroElement;
                }
            } else if (displacementCountOutcome < 0) {
                for (int i = 0; i > displacementCountOutcome; i--) {                         //в цикле все элементы будут смещаться на 1 влево, но при этом на каждой итерации нужно перемещать нулевой элемент на место последнего, а посоедний элемент на место предпоследнего
                    int lastElement = createdArray[createdArray.length - 1];
                    createdArray[createdArray.length-1] = createdArray[0];

                    for (int j = 1; j < createdArray.length - 1; j++) {
                        createdArray[j - 1] = createdArray[j];
                    }
                    createdArray[createdArray.length - 2] = lastElement;
                }
            }
            System.out.println("Полученный массив --> " + Arrays.toString(createdArray));
        }
    }
}
