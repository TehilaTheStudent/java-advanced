package stream_lambda_collections_package;

public class Person_2 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public Person_2(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + "} ";
    }
}
