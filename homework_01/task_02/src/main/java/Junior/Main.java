/*2 Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
2.1 Создать список из 10-20 сотрудников
2.2 Вывести список всех различных отделов (department) по списку сотрудников
2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
2.5 * Из списка сотрудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
*/
package Junior;

public class Main {
    public static void main(String[] args) {
        Сonclusion conclusion = new Сonclusion();
        conclusion.addEmployee();
        conclusion.getVariousDepartments();
        conclusion.salaryIncrease();
        conclusion.getMapEmployee();
        conclusion.getMapSalary();
    }
}