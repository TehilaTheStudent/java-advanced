package Model_package;

public class Customer {
    private long id;
    private String name;
    private String asddress;

    public Customer(long id, String name, String asddress) {
        this.id = id;
        this.name = name;
        this.asddress = asddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsddress() {
        return asddress;
    }

    public void setAsddress(String asddress) {
        this.asddress = asddress;
    }

    @Override
    public String toString() {
        return " Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", asddress='" + asddress + '\'' +
                "} ";
    }
}
