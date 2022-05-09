package lesson_5;

public class Employee {
    private String firstName;
    private String secondName;
    private String surname;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String firstName, String secondName,
                    String surname, String position, String email,
                    String phone, int salary, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployee() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s %s  email: %s  phone:%s  salary: %d   age: %d",
                position, firstName, secondName, surname,
                email, phone, salary, age);
    }

}
