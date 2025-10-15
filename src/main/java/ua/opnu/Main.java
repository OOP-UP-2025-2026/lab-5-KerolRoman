package ua.opnu;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("Коваль", "Іван", 40);
        Student s1 = new Student("Крецу", "Роман", 18, "УП-241", "ST12345");
        Student s2 = new Student("Мельник", "Андрій", 19, "УІ-241", "ST32523");
        Lecturer l1 = new Lecturer("Шевченко", "Марія", 45, "Комп’ютерних наук", 18000);
        Lecturer l2 = new Lecturer("Бойко", "Олег", 50, "Кібур безпеки", 20000);


        Person[] people = {p1, s1, s2, l1, l2};


        for (Person person : people) {
            System.out.println(person.toString());
        }

    }
}