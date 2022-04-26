package lesson_5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иван", "Иванович", "Иванов",
                "Директор", "ivanov@gmail.com", "+37529123456",
                2000, 50);
        employees[1] = new Employee("Ольга", "Ольговна", "Иванова",
                "Жена директора", "ivanova@gmail.com", "+37529123457",
                1999, 25);
        employees[2] = new Employee("Анастасия", "Сигизмундовна", "Хитроделанная",
                "Главный бухгалтер", "buh@gmail.com", "+37529000003",
                1500, 66);
        employees[3] = new Employee("Борис", "Федорович", "Сидоров",
                "Заместитель директора по несложным вопросам", "haljyva@gmail.com",
                "+37529666666", 1500, 30);
        employees[4] = new Employee("Пётр", "Петрович", "Петров",
                "Рабочий", "petrov@gmail.com",
                "+375296333333", 500, 45);

//5.
        Arrays.stream(employees).filter(employee -> employee.getAge() > 40).forEach(employee -> employee.printEmployee());

    }

}
