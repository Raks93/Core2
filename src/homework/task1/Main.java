package homework.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static final Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
            null
    };

    public static void main(String[] args) {


        Map<String, Long> people = getStringLongMap(RAW_DATA);


        for (Map.Entry<String, Long> entry : people.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static Map<String, Long> getStringLongMap(Person[] arrayPerson) {

        return Arrays.stream(arrayPerson)
                .distinct()
                .filter(Main::checkPerson)
                .sorted(comparatorByNameThenId())
                .collect(Collectors.groupingBy(Person::getName, LinkedHashMap::new, Collectors.counting()));
    }

    private static boolean checkPerson(Person person) {

        return !(Objects.isNull(person)
                || person.getName() == null
                || person.getName().isEmpty()
                || person.getId() < 0);
    }

    private static Comparator<Person> comparatorByNameThenId() {
        Comparator<Person> comparator = Comparator.comparing(Person::getName);
        comparator = comparator.thenComparing(Person::getId);
        return comparator;
    }




}
