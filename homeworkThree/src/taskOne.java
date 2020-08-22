import java.util.Random;
import java.util.Scanner;

public class taskOne {
    public static void main(String[] args) {
        int maxOfRandom = 10;
        int randomNumber = randomNumber(maxOfRandom);

        guessRandomNumber(randomNumber, maxOfRandom);
    }

    private static void guessRandomNumber(int randomNumber, int maxOfRandom) {
        int countOfLives = 3;
        Scanner scanner = new Scanner(System.in);
        int resumeStatus = 0;

        do {
            for (int i = 0; i < 3; i++) {
                System.out.println("Введите число от 0 до " + (maxOfRandom - 1));
                int guessingNumber = scanner.nextInt();
                if (guessingNumber != randomNumber) {
                    System.out.println("Вы не угадали, попробуйте ещё раз. У вас осталось " + (countOfLives - 1) + " попыток");
                    if (guessingNumber > randomNumber) {
                        System.out.println("Ваше число больше, чем загаданное");
                    } else {
                        System.out.println("Ваше число меньше, чем загаданное");
                    }
                    countOfLives--;
                } else {
                    System.out.println("Вы победили!");
                    break;
                }
                System.out.println(i);
            }
            System.out.println("Повторить игру ещё раз? /1 - да, 0 - нет");
            resumeStatus = scanner.nextInt();
        } while (resumeStatus > 0);
    }

    private static int randomNumber(int maxOfRandom) {
        Random random = new Random();
        return random.nextInt(maxOfRandom);
    }
}
