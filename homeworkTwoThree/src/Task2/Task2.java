package Task2;

public class Task2 {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add(1234567, "Kitaev");
        phonebook.add(34287492,"Kitaev");
        phonebook.add(2385723, "Ivanov");
        phonebook.add(2837482, "Ivanova");

        System.out.println("================");
        phonebook.get("Kitaev");
        System.out.println("-------------");
        phonebook.get("Sidorov");
        System.out.println("================");
    }
}
