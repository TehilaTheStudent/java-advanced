package LibraryManagingPackage;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Lend {
    private int codeBook;
    private int codeCustomer;
    private Date lendDate;
private boolean returened;

    public boolean isReturened() {
        return returened;
    }

    public void setReturened(boolean returened) {
        this.returened = returened;
    }

    public Lend(int codeBook, int codeCustomer, Date lendDate) {
        this.codeBook = codeBook;
        this.codeCustomer = codeCustomer;
        this.lendDate = lendDate;
        returened=false;
    }
public static Lend makeLend(int codeCustomer, HashMap<Integer,Book> bookHashMap, int codeBook){
        if(bookHashMap.keySet().contains(codeBook)&&bookHashMap.get(codeBook).getNum()>0){
            bookHashMap.get(codeBook).takeBook();
            return new Lend(codeBook,codeCustomer,new Date());
        }
    System.out.println("<><><> cant find book or book is taken");
        return null;
}
public void returnLend(Lend lend, HashMap<Integer,Book> integerBookHashMap){
        if(integerBookHashMap.containsKey(lend.codeBook)){
            lend.returened=true;
            integerBookHashMap.get(lend.codeBook).returnBook();
            return;
        }
    System.out.println("<><><>cant find the book you took!");
}
    public int getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(int codeBook) {
        this.codeBook = codeBook;
    }

    public int getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(int codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }
}
