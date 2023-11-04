package CollenctionsPackage;

import java.nio.file.ClosedWatchServiceException;
import java.util.Arrays;
import java.util.Collections;

public class GlobalCollection<T> implements CollectionsOperations<T> {//כל המחלקות שיהיה להם אוסף גלובלקולקשן: יהיה להם equals ו conpareable
    private T array[];
    private int index;//מאותחל ב-0 אוטומטית לא צריך לאתחל
    public GlobalCollection() {
        array=(T[]) new Object[5];
        System.out.println(array.length);
    }
    public GlobalCollection(int size) {
        array=(T[])new Object[size];
    }
    // בכל הפונקציות יש לרוץ רק עד הindex ולא עד ה size של המערך
    public void remove(int i)
    {
        if(i<0 || i>index){
            System.out.println("problem in remove");
           return;
        }
        System.arraycopy(array,i+1,array,i,index-i-1);
        // TODO האם המיקום הגיוני
index--;//לא לשכוח!!!!
array[index]=null;//למחוק את המיותר בסוף
    }
    public boolean isFull()
    {
        return index==array.length;
    }

    public T get(int i)
    { if(i>=0 && i<index)

        return array[i];
        System.out.println("problen in get");
     return null;
    }
   public T[]  toArray() {
        return array;
        // TODO  פונקצית get למערך של הקלאס
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public void add(T obj) {
        if(index< array.length){
            array[index++]=obj;
        }
        else{
            System.out.println("problem in add");
        }
        // TODO לבדוק אם יש מקום
    }

    @Override
    public void remove(T obj) {
        int ind=contains(obj);
        if (ind!=-1){
            remove(ind);
        }
        // אולי אפשר להשתמש בcontains ואז גם בremove השני
    }

    @Override
    public boolean isEmpty() {
        return index==0;
    }

    @Override
    public void printSort() {

        System.out.print("sorting the array, ");
        Arrays.sort(array);
printAll();

        // מחייב שלכל הקלאסים יהיה Comparable;
    }

    @Override
    public int contains(T obj) {
        for (int i=0;i<index;i++){
            if (array[i].equals(obj)){
                return i;
            }
        }
        // מחייב שלכל הקלאסים יהיה equals
        return -1;
    }

    @Override
    public void clear() {
        for (int i=0;i<index;i++)
            array[i]=null;
index=0;
    }

    @Override
    public String toString() {
        // מחייב שלכל הקלאסים יהיה toString
        return "GlobalCollection{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
public void printAll(){
    System.out.println("print all:");
        for (int i=0;i<index;i++){

            System.out.print(i+": "+array[i].toString()+",  ");
        }
    System.out.println();
    System.out.println("finished printing");

}
//    @Override
//
//    public boolean equals(T o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        GlobalCollection that = (GlobalCollection) o;//אותו מחלקה לא null
//        return Arrays.equals(array, that.array);//,בשביל זה צריך לממש את-equalsהשוואת מערכים
//    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    //ממירה מאוסף למערך
}
