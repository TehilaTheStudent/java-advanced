package LibraryManagingPackage;

public class Book {
    static int id;
    private int code;
    private String name;
    private int num;

    public Book(String name, int num) {
        this.code = id++;
        this.name = name;
        this.num = num;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
public void takeBook(){
        if(num==0)
            throw new RuntimeException("no books to take!!");
        num--;
}
    public void returnBook(){
        num++;
    }
    @Override
    public String toString() {
        return "Book{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
