package Task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Phonebook {

    private Map<Integer, String> Phonebook;

    Phonebook() {
        Phonebook = new HashMap<>();
    }

    public void add(int number, String surname) {
        Phonebook.put(number, surname);
    }

    public void get(String surname) {
        if (Phonebook.containsValue(surname)) {
            Set<Map.Entry<Integer, String>> set = Phonebook.entrySet();
            for (Map.Entry<Integer, String> integerStringEntry : set) {
                if (integerStringEntry.getValue().equals(surname)) {
                    System.out.println(integerStringEntry.getValue() + ":" + integerStringEntry.getKey());
                }
            }
        } else {
            System.out.println(surname + " - Такой фамилии нет в телефонной книге!");
        }
    }
}
