package com.example.app;

import java.util.*;

public class SecondLesson {

    private static final String VERSION = "1.0.0";

    private Integer age;
    private String name;
    private Boolean isAdult;

    private Map<String, List<String>> books = new HashMap<>();

    public Map<String, List<String>> getBooks() {
        return books;
    }

    public String addSubject(Scanner scanner) {
        System.out.println("Введите название предмета:");

        while (true) {
            String subject = scanner.nextLine();
            if (subject != null && !subject.trim().isEmpty()) {
                return subject;
            } else {
                System.out.println("Ошибка: только буквы. Попробуйте снова:");
            }
        }
    }

    public String addBook(Scanner scanner) {
        System.out.println("Введите название книги:");

        while (true) {
            String book = scanner.nextLine();
            if (book != null && !book.trim().isEmpty()) {
                return book;
            } else {
                System.out.println("Ошибка: только буквы. Попробуйте снова:");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Second Lesson - Version: " + VERSION);

        Scanner scanner = new Scanner(System.in);
        SecondLesson lesson = new SecondLesson();

        // Ввод имени
        while (true) {
            System.out.println("Введите имя:");
            String inputName = scanner.nextLine();
            if (inputName != null && !inputName.trim().isEmpty()) {
                lesson.name = inputName;
                break;
            } else {
                System.out.println("Ошибка: имя должно содержать только буквы.");
            }
        }

        // Ввод возраста
        while (true) {
            System.out.println("Введите возраст:");
            try {
                lesson.age = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число.");
                scanner.nextLine();
            }
        }

        lesson.isAdult = lesson.age >= 18;

        System.out.println("Имя: " + lesson.name);
        System.out.println("Возраст: " + lesson.age);
        System.out.println("Совершеннолетний: " + lesson.isAdult);

        System.out.println("Начинаем ввод предметов...");

        while (true) {

            String subject = lesson.addSubject(scanner);
            List<String> subjectBooks = new ArrayList<>();

            while (true) {
                String book = lesson.addBook(scanner);
                subjectBooks.add(book);

                System.out.println("Добавить ещё книгу? (yes/no)");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("no")) {
                    break;
                }
            }

            lesson.books.put(subject, subjectBooks);

            System.out.println("Добавить ещё предмет? (yes/no)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("\n# # # RESULTS # # #");
        System.out.println("Books map: " + lesson.getBooks());

        scanner.close();
    }
}
