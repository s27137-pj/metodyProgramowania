public class Person {

    private String name;

    private int age;

    public Person(String name, Integer age) throws InvalidAgeException {
        if (age < 0){
            throw new InvalidAgeException("Wiek nie moze byc <0");
        }
        if (age > 100){
            throw new InvalidAgeException("Wiek nie moze byc >100");
        }
        this.name= name;
        this.age= age;
    }
    public Person(String name){
        this.name= name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Wiek nie moze byc <0");
        }
        if (age > 100) {
            throw new InvalidAgeException("Wiek nie moze byc >100");

        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
