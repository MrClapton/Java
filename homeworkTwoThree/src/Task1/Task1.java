package Task1;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList = UniqueWords.fillArray(myList);
        System.out.println(myList + "\n");
        UniqueWords.printWords(myList);
    }
}
