public class Employer {
    private String FullName;
    private String Position;
    private String Email;
    private String PhoneNumber;
    private int Salary;
    private int Age;

    public Employer(String FullName, String Position, String Email, String PhoneNumber, int Salary, int Age) {
        this.FullName = FullName;
        this.Position = Position;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Salary = Salary;
        this.Age = Age;
    }

    //геттер для просмотра приватного поля Age извне для сравнения в цикле
    public int getAge() {
        return Age;
    }

    public void employerInfo() {
        System.out.println("Работник " + this.FullName);
        System.out.println("Должность - " + this.Position);
        System.out.println("Электронная почта - " + this.Email);
        System.out.println("Контактный номер - " + this.PhoneNumber);
        System.out.println("Зарплата работника - " + this.Salary);
        System.out.println("Возраст работника - " + this.Age);
        System.out.println();
    }
}
