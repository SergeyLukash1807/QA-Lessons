public class Employee {
    private final String name;
    private final String title;
    private final String email;
    private final String phonNumber;
    private final int salary;
    private final int age;

    public Employee(String name, String title, String email, String phonNumber, int salary, int age) {
        this.name=name;
        this.title=title;
        this.email=email;
        this.phonNumber=phonNumber;
        this.salary=salary;
        this.age=age;
    }
    public static void main(String[] args) {
        Employee [] persArray = new Employee[5];
        persArray [0] = new Employee("Иванов Иван Иванович", "Электрик", "ivanivanov1988@gmail.com", "89976575476", 45000, 36);
        persArray [1] = new Employee("Богданов Иван Сергеевич", "Повар", "bogdanovVany@gmail.com", "89959996832", 45000, 27);
        persArray [2] = new Employee("Васильев Сергей Владимирович", "Садовник", "Sergo6543@gmail.com", "89097562847", 35000, 50);
        persArray [3] = new Employee("Кузнецов Никита Васильевич", "Лифтер", "kyznecnikitaa@gmail.com", "89217689090", 25000, 40);
        persArray [4] = new Employee("Борисов Сергей Владимирович", "Администратор", "borisovsergeyv@gmail.com", "89216755665", 35000, 30);

        for (Employee Employee : persArray) {
            System.out.println(Employee);
        }
    }
    @Override
    public String toString() {
        return "ФИО: " + name + ", должность: " + title + ", email: " + email + ", номер телефона: " + phonNumber + ", зарплата: " + salary + ", возраст: " + age;
    }
}
