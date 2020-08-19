package ru.geekbrains.java.homework;


public class homeworkOne {
    public static void main(String[] args) {
        byte byteVal = 127;
        short shortVal = 32767;
        int intVal = 1990;
        long longVal = 9223372036854775807L;
        float floatVal = 155.445f;
        double doubleVal = 1746.5421;
        char charVal = '\u2256' + '\u2256'; //Можно ли вывести в строку 2 символа кодировки? У меня при сложении их как строк получается иероглиф, а не '=='.
        boolean booleanVal = false;

        System.out.println(charVal);

        System.out.println(thirdTask(0.4f,1.24f,10.26f,2.0f));

        System.out.println(fourthTask(10,2));     //true
        System.out.println(fourthTask(10,22));    //false

        fifthTask(10);  //"Получено положительное число"
        fifthTask(-5); //"Получено отрицательное число"

        System.out.println(sixthTask(15));  //false
        System.out.println(sixthTask(-20));  //true

        seventhTask("Алекс");   //"Привет, Алекс!"

        eighthTask(1486);   //Полученный 1486 год не является високосным!

    }

    public static float thirdTask(float a, float b, float c, float d) {
        return (a * (b + (c / d)));
    }

    public static boolean fourthTask(int a, int b) {
        int summ = a + b;
            if ((summ >= 10) && (summ <= 20)) {
                return true;
            } else {
                return false;
            }
    }

    public static void fifthTask(int a) {
        if (a >= 0) {
            System.out.println("Получено положительное число");
        } else {
            System.out.println("Получено отрицательное число");
        }
    }

    public static boolean sixthTask(int b) {
        if (b >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void seventhTask(String sendName) {
        System.out.println("Привет, " + sendName + "!");
    }

    public static void eighthTask(int year) {
        if ((((year % 4) == 0) && ((year % 100) != 0)) || ((year % 400) == 0)) {
            System.out.println("Полученный " + year + " год является високосным!");
        } else {
            System.out.println("Полученный " + year + " год не является високосным!");
        }
    }
}




