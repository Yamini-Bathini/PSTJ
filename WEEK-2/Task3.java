package PSTJ;
import java.util.*;
import java.util.stream.*;
class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    String getName() {
        return name;
    }
    int getAge() {
        return age;
    }
    static boolean isOlderThan(Person p, int ageLimit) {
        return p.age > ageLimit;
    }
}
public class Task3 {
	// TODO Auto-generated method stub
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            persons.add(new Person(parts[0], Integer.parseInt(parts[1])));
        }
        int ageLimit = Integer.parseInt(sc.nextLine());
        persons.stream()
               .sorted(Comparator.comparing(Person::getName))
               .map(Person::getName)
               .forEach(name -> System.out.print(name + " "));
        System.out.println();
        persons.stream()
               .filter(p -> Person.isOlderThan(p, ageLimit))
               .map(Person::getName)
               .forEach(name -> System.out.print(name + " "));
        System.out.println();
        persons.stream()
               .map(Person::getName)
               .map(String::toUpperCase)
               .forEach(name -> System.out.print(name + " "));
    }
}

