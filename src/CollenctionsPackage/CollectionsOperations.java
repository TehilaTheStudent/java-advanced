package CollenctionsPackage;

public interface CollectionsOperations<T> {
    int size();
    void add(T obj);
    void remove(T obj);

    boolean isEmpty();

    void printSort();

    int contains(T obj);

    void  clear();




}

