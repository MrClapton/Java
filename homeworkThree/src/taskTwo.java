import java.util.Random;
import java.util.Scanner;

public class taskTwo {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        guessTheWorld(words);
    }

    private static void guessTheWorld(String[] words) {
       Random generator = new Random();
       Scanner scanner = new Scanner(System.in);
       StringBuilder consoleWord = new StringBuilder("###############");

       //генерация случайного слова из заданного массива
       int randomIndex = generator.nextInt(words.length);
       String hiddenWord = words[randomIndex];

        int length;
        int countOfGuessedLetters = 0;

      do {
          //зарпос слова в консооли от пользователя
          System.out.println("Введите слово: ");
          String usersWord = scanner.next();

          //сравнение длин загаданного слова и пользовательского слова, чтобы не выйти за рамки минимальной из длин
          if (hiddenWord.length() < usersWord.length()) {
              length = hiddenWord.length();
          } else {
              length = usersWord.length();
          }

          for (int i = 0; i < (length - 1); i++) {
              char hiddenWordChar = hiddenWord.charAt(i);
              char userWordChar = usersWord.charAt(i);
              if (userWordChar == hiddenWordChar) {
                  countOfGuessedLetters++;
                  consoleWord.setCharAt(i, userWordChar);
              }
          }
          System.out.println(consoleWord);
          System.out.println("Число угаданных букв = " + countOfGuessedLetters);
      }
          while (countOfGuessedLetters < hiddenWord.length());
    }
}
