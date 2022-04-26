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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
