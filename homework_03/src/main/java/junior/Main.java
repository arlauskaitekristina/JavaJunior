/**
 * Написать класс с двумя методами:
 * 1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл. Название файл - class.getName() + "_" + UUID.randomUUID().toString()
 * 2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString() и загружает объект из файла и удаляет этот файл.
 * Что делать в ситуациях, когда файла нет или в нем лежит некорректные данные - подумать самостоятельно.
 */

package junior;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Process> process = Arrays.asList(
                new Process(38, "Анна", "Бухгалтер"),
                new Process(30, "Марина", "Менеджер")
        );

        SerializableObject serializableObject = new SerializableObject();
        serializableObject.writingObject(process);
        serializableObject.readingObject(serializableObject.getPath());
    }
}