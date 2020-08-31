import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //Employes TestEmployer = new Employes("Иванов Иван Иванович", "Разработчик", "ivanovivan@mail.ru", randomNumber(999999999), randomSalary(80000), randomAge(65));
        //TestEmployer.employerInfo();
        Employer[] EmployersArray = new Employer[5];
        EmployersArray[0] = new Employer("Соколов Андрей Васильевич", "Директор", "sokolov@mail.ru", randomNumber(), randomSalary(80000), randomAge(18, 65));
        EmployersArray[1] = new Employer("Деревянко Александр Олегович", "Менеджер", "derevoleg@yandex.ru", randomNumber(), randomSalary(20000), randomAge(18, 65));
        EmployersArray[2] = new Employer("Цыганова Валентина Юрьевна", "Администратор", "ciganova@mail.ru", randomNumber(), randomSalary(40000), randomAge(18, 55));
        EmployersArray[3] = new Employer("Сыромяткин Юрий Антонович", "Зам.директора", "syromyatkin@yandex.ru", randomNumber(), randomSalary(70000), randomAge(18, 65));
        EmployersArray[4] = new Employer("Богданова Юлия Алексеевна", "Менеджер", "bogdanova@mail.ru", randomNumber(), randomSalary(20000), randomAge(18, 55));

        for (Employer employer : EmployersArray) {
            if (employer.getAge() > 40) {
                employer.employerInfo();
            } else {
                System.out.println("Возраст сотрудника меньше 40 лет! - " + employer.getAge());
                System.out.println();
            }
        }
    }

    private static int randomSalary(int maxSalary) {
        Random generator = new Random();
        return generator.nextInt(maxSalary);
    }

    private static int randomAge(int minAge, int maxAge) {
        Random generator = new Random();
        //return generator.nextInt(maxAge);
        return minAge + generator.nextInt(maxAge - minAge + 1);
    }

    private static String randomNumber() {
        Random generator = new Random();
        String number = "+79";
        int SecondPart = generator.nextInt(999999999);
        number += SecondPart;
        return number;
    }

}
