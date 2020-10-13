import java.util.Arrays;

/*
В целях экономии места в консоли, были закомментированы команды вывода элементов массива, т.к. оценить реальный выигрыш многопоточности по времени удается только при обработке объеных данных.

SIZE не делал final переменной, т.к. решил добавить проверку при создании массива, чтобы он разбивался пополам. В случае, если число элементов нечетное, тогда в переменную SIZE производится инкрементация
 */

@SuppressWarnings("IntegerDivisionInFloatingPointContext")
public class Threads {
    static int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    //---Переменные, в которых будет храниться время завершения 1-го и 2-го потоков, а также время выполнения 2-го метода(для 1-го метода аналогичная переменная объявлена внутри него)---
    static long b1 = 0, b2 = 0, time;

    public static void main(String[] args) {
        /*firstMethod(createArr());
        secondMethod(createArr());*/
        System.out.println("==================START=================");
        whichFaster(firstMethod(createArr()), secondMethod(createArr()));
    }

    //---Метод, создающий одномерный массив размера SIZE и наполняющий его значениями 1---
    public static float[] createArr() {
        if ((SIZE%2) == 0) {
            float[] arr = new float[SIZE];
            Arrays.fill(arr, 1);
            return arr;
        } else {
            SIZE++;
            float[] arr = new float[SIZE];
            Arrays.fill(arr, 1);
            System.out.println("На вход был подан массив с нечетным количеством элементов. Задана новая размерность. Length = " + arr.length);
            return arr;
        }
    }

    //---Реализация 1 метода, который совершает прямой обход массива данных, заполняя элементы вычисляемыми значениями---
    private static long firstMethod(float[] arr) {

        //System.out.println("Исходное состояние массива в методе 1: " + Arrays.toString(arr));
        long a = System.currentTimeMillis();
        long time;
        for (int i=0; i<arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        //System.out.println("Массив после рассчетов в методе 1: " + Arrays.toString(arr));
        time = System.currentTimeMillis() - a;
        System.out.println("Ушло времени на рассчеты в методе 1: " + time + " ms");

        return time;
    }

    //---Реализация 2 метода, который разбивает исходный массив на 2 равных по размерам массива, после чего создается 2 потока, каждый из которых заполняет элементы своего массива. Когда массивы заполнены, производится склейка массивов в исходный---
    private static long secondMethod(float[] arr) {

        float[] arrOne = new float[HALF];
        float[] arrTwo = new float[HALF];
        long b = System.currentTimeMillis();

        //---Разбивка исходного массива на 2 равных---
        System.arraycopy(arr,0, arrOne, 0, HALF);
        System.arraycopy(arr, HALF, arrTwo, 0, HALF);
        /*System.out.println("Первый массив: " + Arrays.toString(arrOne));
        System.out.println("Второй массив: " + Arrays.toString(arrTwo));*/

        //---Создание объекта потока #1---
        Thread firstCalc = new Thread(() -> {
            for (int i = 0; i < arrOne.length; i++) {
                arrOne[i] = (float) (arrOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            b1 = System.currentTimeMillis() - b;
        });
        firstCalc.start();//---Вызов метода start потока #1(после чего JVM вызывает метод run этого же потока)---

        //---Создание объекта потока #2---
        Thread secondCalc = new Thread(new Runnable() {
            @SuppressWarnings("IntegerDivisionInFloatingPointContext")
            @Override
            public void run() {
                for (int i = 0; i < arrTwo.length; i++) {
                    arrTwo[i] = (float) (arrTwo[i] * Math.sin(0.2f + (i+HALF) / 5) * Math.cos(0.2f + (i+HALF) / 5) * Math.cos(0.4f + (i+HALF) / 2));
                }
                b2 = System.currentTimeMillis() - b;
            }
        });
        secondCalc.start();//---Вызов метода start потока #2(после чего JVM вызывает метод run этого же потока)---

        //---Секция try-catch для обработки исключений потоков---
        try {
            firstCalc.join();
            secondCalc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrOne, 0, arr, 0, HALF);
        System.arraycopy(arrTwo, 0, arr, HALF, HALF);
        /*System.out.println("Полученный после склейки массив: " + Arrays.toString(arr));*/
        time = System.currentTimeMillis() - b;
        System.out.println("Ушло времени на рассчеты в методе 2: " + time + " ms");
        System.out.println("------------------------------------------");
        System.out.println("Первый поток завершился через " + b1 + " ms");
        System.out.println("Второй поток завершился через " + b2 + " ms");
        System.out.println("------------------------------------------");
        return time;

    }

    private static void whichFaster(long firstTime,long secondTime) {
        if (firstTime > secondTime) {
            System.out.println("Второй метод сработал быстрее!");
        } else {
            System.out.println("Первый метод сработал быстрее!");
        }
        System.out.println("===================END===================");
    }


}
