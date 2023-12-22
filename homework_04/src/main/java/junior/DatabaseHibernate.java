package junior;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/*
 * 2. С помощью JPA(Hibernate) выполнить:
 * 2.1 Описать сущность Book из пункта 1.1
 * 2.2 Создать Session и сохранить в таблицу 10 книг
 * 2.3 Выгрузить список книг какого-то автора
 */
public class DatabaseHibernate {
    final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
    Book book;

    /**
     * Метод создания и заполнения таблицы BOOKS
     */
    public void createTableBook() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Author author1 = new Author("Уайльд Оскар");
            session.persist(author1);

            Author author2 = new Author("Остин Джейн");
            session.persist(author2);

            Author author3 = new Author("Александр Дюма");
            session.persist(author3);

            Author author4 = new Author("Митчелл Маргарет");
            session.persist(author4);

            Author author5 = new Author("Лев Толстой");
            session.persist(author5);

            Author author6 = new Author("Шарлотта Бронте");
            session.persist(author6);

            Author author7 = new Author("Эрих Мария Ремарк");
            session.persist(author7);

            Author author8 = new Author("Джордж Оруэлл");
            session.persist(author8);

            Author author9 = new Author("Кронин Арчибальд Джозеф");
            session.persist(author9);

            Author author10 = new Author("Михаил Булгаков");
            session.persist(author10);


            book = new Book("Портрет Дориана Грея", author1);
            session.persist(book);

            book = new Book("Гордость и предубеждение", author2);
            session.persist(book);

            book = new Book("Королева Марго", author3);
            session.persist(book);

            book = new Book("Унесенные ветром", author4);
            session.persist(book);

            book = new Book("Анна Каренина", author5);
            session.persist(book);

            book = new Book("Джейн Эир", author6);
            session.persist(book);

            book = new Book("Триумфальная арка", author7);
            session.persist(book);

            book = new Book("Скотный двор", author8);
            session.persist(book);

            book = new Book("Цитадель", author9);
            session.persist(book);

            book = new Book("Мастер и Маргарита", author10);
            session.persist(book);

            session.getTransaction().commit();
        }
    }

    /**
     * Метод поиска в базе данных по автору
     *
     * @param searchAuthor строка (имя автора)
     */
    public void getBooksByAuthor(String searchAuthor) {
        try (Session session = sessionFactory.openSession()) {
            List<Book> books = session.createQuery(
                            "FROM Book WHERE author = (FROM Author WHERE nameAuthor = :name_author)", Book.class
                    ).setParameter("name_author", searchAuthor)
                    .getResultList();

            books.forEach(System.out::println);
        }
    }

    /**
     * Метод закрытия сессии
     */
    public void closedSession() {
        sessionFactory.close();
    }
}
