package LibraryManagingPackage;

import java.util.Objects;

public class Customer implements Comparable {
    static int id;
    private int code;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return code == customer.code && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    public Customer(String name) {
        this.code = id++;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
       // return 0;
      return ((Customer)o).getName().compareTo(getName());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
