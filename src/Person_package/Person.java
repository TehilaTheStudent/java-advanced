package Person_package;

import java.util.Objects;

public class Person implements Comparable{

private int id;
private String name;

    @Override
    public int compareTo(Object o) {
        //   return ((Person)o).id-this.id//מסדר מהגדול לקטן;
        return this.id- ((Person)o).id;//מסדר מקטן לגדול;
        //TODO check if this is right ans: it is rigth!
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {

        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;//אותו מחלקה ואותו תכונות
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
