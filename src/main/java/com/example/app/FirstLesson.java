package com.example.app;

import java.util.*;

public class FirstLesson {

    private static final boolean firstVar = true;
    private static final String secondVar = "Hello Maven";

    private Integer thirdVar;
    private Integer fourthVar;
    private String fifthVar;

    private Map<String, Integer> sixthVar = new HashMap<>();
    private List<String> seventhVar = new ArrayList<>();
    private Set<Integer> eighthVar = new HashSet<>();

    public Integer getThirdVar() { return thirdVar; }
    public void setThirdVar(Integer thirdVar) { this.thirdVar = thirdVar; }

    public Integer getFourthVar() { return fourthVar; }
    public void setFourthVar(Integer fourthVar) { this.fourthVar = fourthVar; }

    public String getFifthVar() { return fifthVar; }
    public void setFifthVar(String fifthVar) { this.fifthVar = fifthVar; }

    public Map<String, Integer> getSixthVar() { return sixthVar; }
    public List<String> getSeventhVar() { return seventhVar; }
    public Set<Integer> getEighthVar() { return eighthVar; }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FirstLesson lesson = new FirstLesson();

        System.out.println("FirstVar: " + firstVar);
        System.out.println("SecondVar: " + secondVar);

        // thirdVar с проверкой
        boolean thirdVarChecker = false;
        while (!thirdVarChecker) {
            System.out.print("Введите значение для thirdVar (число): ");
            try {
                lesson.setThirdVar(scanner.nextInt());
                thirdVarChecker = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число.");
                scanner.nextLine();
            }
        }

        // fourthVar с проверкой
        boolean fourthVarChecker = false;
        while (!fourthVarChecker) {
            System.out.print("Введите значение для fourthVar (число): ");
            try {
                lesson.setFourthVar(scanner.nextInt());
                fourthVarChecker = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число.");
                scanner.nextLine();
            }
        }

        scanner.nextLine(); // очистка буфера

        // fifthVar
        System.out.print("Введите значение для fifthVar (строка): ");
        lesson.setFifthVar(scanner.nextLine());

        // sixthVar (Map)
        for (int i = 0; i < 3; i++) {
            System.out.print("Введите ключ: ");
            String key = scanner.nextLine();

            System.out.print("Введите значение (число): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите число!");
                scanner.next();
            }
            int value = scanner.nextInt();
            scanner.nextLine();

            lesson.getSixthVar().put(key, value);
        }

        // seventhVar (List)
        for (int i = 0; i < 5; i++) {
            System.out.print("Введите элемент списка: ");
            lesson.getSeventhVar().add(scanner.nextLine());
        }

        // eighthVar (Set)
        for (int i = 0; i < 3; i++) {
            System.out.print("Введите число в Set: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите число!");
                scanner.next();
            }
            lesson.getEighthVar().add(scanner.nextInt());
        }

        System.out.println("\n# # # RESULTS # # #");
        System.out.println("ThirdVar: " + lesson.getThirdVar());
        System.out.println("FourthVar: " + lesson.getFourthVar());
        System.out.println("FifthVar: " + lesson.getFifthVar());
        System.out.println("SixthVar (Map): " + lesson.getSixthVar());
        System.out.println("SeventhVar (List): " + lesson.getSeventhVar());
        System.out.println("EighthVar (Set): " + lesson.getEighthVar());

        scanner.close();
    }
}
