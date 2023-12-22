package junior;

import java.sql.*;

/*
 * 1. С помощью JDBC выполнить:
 * 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...
 * 1.2 Добавить в таблицу 10 книг
 * 1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet
 */
public class DatabaseJDBC {
    private final String nameTable = "books";
    private final String columnId = "id";
    private final String columnName = "name_book";
    private final String columnAuthor = "author";

    /**
     * Метод получения записи из базы данных
     *
     * @param connection соединение с базой данных
     */
    public void getData(Connection connection, String searchAuthor) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("""
                    SELECT * FROM %s WHERE %s = '%s'
                    """.formatted(nameTable, columnAuthor, searchAuthor)
            );
            while (resultSet.next()) {
                int id = resultSet.getInt(columnId);
                String name = resultSet.getString(columnName);
                String author = resultSet.getString(columnAuthor);
                System.out.println(columnId + ": " + id + ",\n" +
                        columnName + ": " + name + ",\n" +
                        columnAuthor + ": " + author
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод заполнения таблицы BOOKS в базе данных
     *
     * @param connection соединение с базой данных
     */
    public void insertData(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("""
                    insert into %s(%s, %s, %s)
                    values(1, 'Портрет Дориана Грея', 'Уайльд Оскар'),
                          (2, 'Гордость и предубеждение', 'Остин Джейн'),
                          (3, 'Королева Марго', 'Александр Дюма'),
                          (4, 'Унесенные ветром', 'Митчелл Маргарет'),
                          (5, 'Анна Каренина', 'Лев Толстой'),
                          (6, 'Джейн Эир', 'Шарлотта Бронте'),
                          (7, 'Триумфальная арка', 'Эрих Мария Ремарк'),
                          (8, 'Скотный двор', 'Джордж Оруэлл'),
                          (9, 'Цитадель', 'Кронин Арчибальд Джозеф'),
                          (10, 'Мастер и Маргарита', 'Михаил Булгаков'),
                    """.formatted(nameTable, columnId, columnName, columnAuthor)
            );
            System.out.println("Таблица " + nameTable + " заполнена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод создания таблицы BOOKS в базе данных
     *
     * @param connection соединение с базой данных
     */
    public void prepareTables(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(" DROP TABLE IF EXISTS " + nameTable);
            statement.execute(""" 
                    CREATE TABLE %s(
                    %s BIGINT,
                    %s varchar(100),
                    %s VARCHAR(100)
                    );
                    """.formatted(nameTable, columnId, columnName, columnAuthor)
            );
            System.out.println("Создана таблица " + nameTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод создания соединения с базой данных
     */
    public Connection dbConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./dbJDBC.db");
            Statement statement = connection.createStatement();
//            statement.execute("CREATE SCHEMA IF NOT EXISTS " + schemaName); // если не файловая бд
            statement.close();
            System.out.println("Соединение с БД установлено");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод закрытия соединения с базой данных
     *
     * @param connection соединение с базой данных
     */
    public void dbClose(Connection connection) {
        try {
            connection.close();
            System.out.println("Соединение с БД разорвано");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
