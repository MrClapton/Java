import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //массив из 5 объектов класса Employer
        Employer[] EmployersArray = new Employer[5];
        //инициализация объектов в массиве
        EmployersArray[0] = new Employer("Соколов Андрей Васильевич", "Директор", "sokolov@mail.ru", randomNumber(), randomSalary(65000,80000), randomAge(18, 65));
        EmployersArray[1] = new Employer("Деревянко Александр Олегович", "Менеджер", "derevoleg@yandex.ru", randomNumber(), randomSalary(20000,28000), randomAge(18, 65));
        EmployersArray[2] = new Employer("Цыганова Валентина Юрьевна", "Администратор", "ciganova@mail.ru", randomNumber(), randomSalary(35000,40000), randomAge(18, 55));
        EmployersArray[3] = new Employer("Сыромяткин Юрий Антонович", "Зам.директора", "syromyatkin@yandex.ru", randomNumber(), randomSalary(55000,65000), randomAge(18, 65));
        EmployersArray[4] = new Employer("Богданова Юлия Алексеевна", "Менеджер", "bogdanova@mail.ru", randomNumber(), randomSalary(20000,28000), randomAge(18, 55));

        for (Employer employer : EmployersArray) {
            if (employer.getAge() > 40) {
                employer.employerInfo();
            } else {
                System.out.println("Возраст сотрудника меньше 40 лет! - " + employer.getAge());
                System.out.println();
            }
        }
    }
    //генерация случайной зарплаты в пределах от minSalary до maxSalary
    private static int randomSalary(int minSalary, int maxSalary) {
        Random generator = new Random();
        //return generator.nextInt(maxSalary);
        return minSalary + generator.nextInt(maxSalary-minSalary+1);
    }
    //генерация случайного возраста в пределах от 18 лет до 55(для женщин) и до 65(для мужчин)
    private static int randomAge(int minAge, int maxAge) {
        Random generator = new Random();
        //return generator.nextInt(maxAge);
        return minAge + generator.nextInt(maxAge - minAge + 1);
    }
    //генерация случайного номера по шаблону +79 + остальные цифры случайные
    private static String randomNumber() {
        Random generator = new Random();
        String number = "+79";
        int SecondPart = 900000000 + generator.nextInt(999999999 - 900000000 + 1);
        number += SecondPart;
        return number;
    }

}
