package Junior;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Сonclusion {
        private final List<Employee> employees = new ArrayList<>();

        /**
         * Метод добавления сотрудников в список
         */
        public void addEmployee() {
            employees.add(new Employee("Сергей", 30, 10000, "Отдел кадров"));
            employees.add(new Employee("Ирина", 40, 50000, "Бухгалтерия"));
            employees.add(new Employee("Константин", 35, 60000, "Отдел по технике безопасности"));
            employees.add(new Employee("Арина", 28, 60000, "Менеджер"));
            employees.add(new Employee("Николай", 40, 90000, "IT"));
            employees.add(new Employee("Кристина", 35, 35000, "Бухгалтерия"));
            employees.add(new Employee("Артем", 28, 35000, "Бухгалтерия"));
            employees.add(new Employee("Мария", 25, 40000, "Менеджер"));
            employees.add(new Employee("Никита", 26, 20000, "Менеджер"));
            employees.add(new Employee("Анна", 30, 34000, "Отдел кадров"));
            employees.add(new Employee("Дмитрий", 50, 34000, "Менеджер"));
            employees.add(new Employee("Василий", 50, 8000, "Оотдел по технике безопасности"));
//        System.out.println(employees);
        }

        /**
         * Метод вывода уникальных значений по полю department
         */
        public void getVariousDepartments() {
            employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
        }

        /**
         * Метод повышения заработной платы сотрудника
         */
        public void salaryIncrease() {
            employees.stream().filter(it -> it.getSalary() < 10000).forEach(it -> it.setSalary(it.getSalary() * 1.2));
            employees.stream().filter(it -> it.getSalary() < 10000).forEach(System.out::println);
        }

        /**
         * Метод формирования коллекции Map по отделу
         */
        public void getMapEmployee() {
            Map<String, List<Employee>> mapEmployee =
                    employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
            mapEmployee.forEach((k, v) -> System.out.println("Отдел: " + k + "\nСотрудники: \n" + v));
        }

        /**
         * Метод формирования коллекции Map средней зарплаты по отделу
         */
        public void getMapSalary() {
            Map<String, Double> mapSalary =
                    employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                            Collectors.averagingDouble(Employee::getSalary)));
            mapSalary.forEach((k, v) -> System.out.println("Отдел: " + k + "; Средняя зарплата по отделу: " + v + " р."));
        }
    }

