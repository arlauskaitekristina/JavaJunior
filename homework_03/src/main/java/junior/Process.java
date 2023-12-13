package junior;

import java.io.Serial;
import java.io.Serializable;

/**
 * Тестовый класс Process для записи в файл
 */
public class Process implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final int age;
    private final String name;
    private final String department;

    public Process(int age, String name, String department) {
        this.age = age;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Process{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
