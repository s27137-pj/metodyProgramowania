import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InvalidAgeException {

        Person person = null;
        try {
            person = new Person("Jan", 72);
        } catch (InvalidAgeException e) {
            out.println("złapano wyjatek" + e.getMessage());
//            throw new RuntimeException(e);
        }

        try {
            Person person2 = new Person("adam", 55);
        } catch (InvalidAgeException e) {
            out.println("złapano wyjatek" + e.getMessage());
//            throw new RuntimeException(e);
        }

        out.printf("imie: " + person.getName() + " wiek: " + person.getAge());


        Person person3 = new Person("Ala", 21);
        Person person4 = new Person("Jas", 34);

         List<Person> immutablePersonList = List.of(person, person4, person3);

        out.println("lista niemutowalna: " + immutablePersonList);

        List<Person> mutablePersonList = new ArrayList<>();
        mutablePersonList.add(person);
        mutablePersonList.add(person3);
        mutablePersonList.add(person4);

        out.println("Lista mutowalna: " + mutablePersonList);

        Set<Person> immutablePersonSet = Set.of(person, person3, person4);
        out.println("Set niemutowalny: " + immutablePersonSet);

        Set<Person> mutablePersonSet = new HashSet<>();
        mutablePersonSet.add(person);
        mutablePersonSet.add(person3);
        mutablePersonSet.add(person4);
        out.println("Set mutowalny: " + mutablePersonSet);

        Map<Integer, Person> imutablePersonMap = Map.of(1, person, 2, person3, 3, person4);
        out.println("Mapa niemutowalna: " + imutablePersonMap);

        Map<String, Person> mutablePersonMap = new HashMap<>();
        mutablePersonMap.put("A", person);
        mutablePersonMap.put("B", person3);
        mutablePersonMap.put("C", person4);
        mutablePersonMap.put("A", person3);

        out.println("Mapa mutowalna: " + mutablePersonMap);

//        Streamy

        List<Integer> ageList = immutablePersonList.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());

        Integer ageSum = ageList.stream()
                .reduce(0, (sum,value) -> sum + value);

        out.println("suma lat: " + ageSum);

        double averageAge = ageSum / ageList.size();

        out.println("Średnia wieku: " + averageAge);

        immutablePersonList.stream()
                .map(p -> p.getAge())
                .reduce(0, (sum, value) -> sum + value);

        out.println("suma stram chain: " + ageSum);

        List<String> names = immutablePersonList.stream()
                .map(e -> e.getName())
                .distinct()
                .collect(Collectors.toList());
        out.println(names);

        List<Person> customerOver25 = immutablePersonList.stream()
                .filter(c -> c.getAge() >25)
                .collect(Collectors.toList());
        out.println("Powyzej 25: " + customerOver25);

        List<String> sortedList = immutablePersonList.stream()
                .map(n -> n.getName())
                .sorted()
                .collect(Collectors.toList());

        out.println("POsortowane alfabetycznie: " + sortedList);

        immutablePersonList.stream()
                .forEach(p -> out.println(p));

        Optional<Person> personWithMinAge = immutablePersonList.stream()
                .min(Comparator.comparingInt(Person::getAge));

        personWithMinAge.ifPresentOrElse(p -> out.println("Minimalny wiek: " + p.getAge()),
        () -> out.println("Nie odnaleziono takiej osoby"));


















    }
}