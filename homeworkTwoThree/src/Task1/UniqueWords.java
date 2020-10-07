package Task1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UniqueWords {
    public static List<String> fillArray(List<String> myArray) {
        myArray.add("first");
        myArray.add("Second");
        myArray.add("Third");
        myArray.add("First");
        myArray.add("Fifth");
        myArray.add("Ninth");
        myArray.add("Seventh");
        myArray.add("second");
        myArray.add("Eights");
        myArray.add("First");
        return myArray;
    }
    //метод выполнен при том условии, что за повтор учитываются слова с разным регистром, но одинаковым содержанием
    public static void printWords (List<String> array) {
        Set<String> uniqueArray = new LinkedHashSet<>();
        for (String s : array) {
            String lowerWord = s.toLowerCase();
            uniqueArray.add(lowerWord);
        }

        for (String s : uniqueArray) {
            int count = 0;
            for (String s1 : array) {
                String lowerWord = s1.toLowerCase();
                if (s.equals(lowerWord)) count++;
            }
            System.out.println("|" + s + "|" + " repeated at List " + count + " times");
        }
        System.out.println();
    }
}
