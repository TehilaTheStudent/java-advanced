package firstpackage;
import CollenctionsPackage.GlobalCollection;
import CollenctionsPackage.Person;
import LibraryManagingPackage.*;
import stream_lambda_collections_package.Person_2;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        //  <editor-fold-desc="2nd lesson hw page 1 2 3 4 volunteers">
        Doctor d1 = new Doctor(new PersonalDetails("034536615", 40, "Penina", "Aharonovich"), false, Days.FRIDAY, 30, Title.APPRENTICE, 2);
        Doctor d2 = new Doctor(new PersonalDetails("325931301", 18, "Tehila", "Aharonovich"), false, Days.THURSDAY, 10, Title.NURSE, 2);
        Visitor v1 = new Visitor(new PersonalDetails("335388682", 12, "Avigail", "Aharonovich"), false, Days.WEDNESDAY, 39, State.SINGLE);
        Visitor v2 = new Visitor(new PersonalDetails("034331485", 41, "Naftali", "Aharonovich"), false, Days.MONDAY, 88, State.MARRIED);

//hw pages 1&2
        for (State si : State.values()) {
            System.out.println("ordinal " + si.ordinal() + "name " + si.name());
        }
        for (Days di : Days.values()) {
            System.out.println("ordinal " + di.ordinal() + "name " + di.name());
        }
        for (Title i : Title.values()) {
            System.out.println("ordinal " + i.ordinal() + "name " + i.name());
        }
        System.out.println("d1 bonus:" + d1.calcBonus());
        System.out.println("d2 bonus:" + d2.calcBonus());
        System.out.println("v1 bonus:" + v1.calcBonus());
        System.out.println("v2 bonus:" + v2.calcBonus());
        //   hw pages 3&4
        VolCollection vc1 = new VolCollection();
        vc1.addVolunteer(v1);
        vc1.addVolunteer(v2);
        vc1.addVolunteer(d1);
        vc1.addVolunteer(d2);
        Volunteer volunteer = vc1.search(1, 13, Days.SUNDAY);
        if (volunteer == null) {
            System.out.println("null, didnt find any volunteer");
        } else {
            System.out.println("found " + volunteer.getPerDet().getFirstName());
        }
//</editor-fold>
//<editor-fold-desc="3rd lesson reflection">
        Rectangle rectObj1 = new Rectangle();
        Class rectClass1 = rectObj1.getClass();
        Class<Box> boxClass2 = Box.class;
        try {
            Class volunteerClass1 = Class.forName("firstpackage.Volunteer");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("toString: " + rectClass1.toString() + "\ngetSimpleName: "
                + rectClass1.getSimpleName() + "\ngetTypeName: " +
                rectClass1.getTypeName() + "\ngetPackageName: " + rectClass1.getPackageName()
                + "\ngetName: " + rectClass1.getName() + "\ngetCanonicalName: " + rectClass1.getCanonicalName()
                + "\ndescriptorString: " + rectClass1.descriptorString() + "\ntoGeneticString: " + rectClass1.toGenericString());
        System.out.println("getModofiers" + Modifier.toString(rectClass1.getModifiers()));
        System.out.println("getSuperClass: " + boxClass2.getSuperclass().getSimpleName());

        try {
            System.out.println("newInstance: " + rectClass1.newInstance().toString());
            // Use the newly created instance as needed

        } catch (InstantiationException e) {
            // Handle InstantiationException
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            // Handle IllegalAccessException
            e.printStackTrace();
        }
        for (Field fi : rectClass1.getFields()) {
            System.out.println("fields: name " + fi.getName() + " type " + fi.getType().getSimpleName() + " modifier " + Modifier.toString(fi.getModifiers()));
        }
        for (Method mi : rectClass1.getDeclaredMethods()) {
            System.out.println("methods: name " + mi.getName() + " parameter count " + mi.getParameterCount() + " returns " + mi.getReturnType().getSimpleName());
        }
        for (Constructor ci : rectClass1.getDeclaredConstructors()) {
            System.out.println("constructors: name " + ci.getName() + " parameter types" + Arrays.toString(ci.getParameterTypes()));
        }
        Class personalDetailsClass1 = PersonalDetails.class;
        try {
            PersonalDetails personalDeilsObj1 = (PersonalDetails) personalDetailsClass1.getConstructor(null).newInstance();
            personalDeilsObj1.getClass().getDeclaredFields()[0].set(personalDeilsObj1, "string");
            personalDeilsObj1.getClass().getMethod("setId", String.class).invoke(personalDeilsObj1, "put id using reflection");
            System.out.println(personalDeilsObj1.toString());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // </editor-fold
//<editor-fold desc="4th lesson GlobalCollection">

        GlobalCollection<Integer> gbInt = new GlobalCollection<>();
        for (int i = 0; i < gbInt.capacity(); i++) {
            gbInt.add(10 - i);
        }
        GlobalCollection<String> gbString = new GlobalCollection<>();
        for (int i = 0; i < gbString.capacity(); i++) {
            gbString.add("abcdefg".substring(0, "abcdefg".length() - i));
        }
        GlobalCollection<Person> gbPerson = new GlobalCollection<>();
        for (int i = 0; i < gbPerson.capacity() - 1; i++) {
            gbPerson.add(new Person(12 - i, "Tehila"));
        }
        gbPerson.add(new Person(11, "Tehila"));
        //use printSort
        gbInt.printSort();
        gbString.printSort();
        gbPerson.printSort();
        //use remove
        gbPerson.remove(gbPerson.get(2));
        gbPerson.printAll();
        //use full clear toString
        gbPerson.add(new Person(123, "Tili"));
        System.out.println(gbPerson.toString());

        if (gbPerson.isFull()) {
            System.out.println("clearing because its full");
            gbPerson.clear();
        }
        System.out.println("is empty? " + gbPerson.isEmpty());
        //use equals
        GlobalCollection<String> gb1 = new GlobalCollection<>();
        gb1.add("abc");
        GlobalCollection<String> gb2 = new GlobalCollection<>();
        gb2.add("abc");
        System.out.println("are equals? " + gb1.equals(gb2));

        //</editor-fold>
        // <editor-fold desc="5th lesson java collection>
        Vector<String> vec1 = new Vector<>();
        vec1.add("a");
        vec1.add("b");
        vec1.add("c");
        vec1.add("d");
        vec1.add("e");
//        String [] s1= (String[]) vec1.toArray();
//        String [] s2=  vec1.toArray(s1);
        //use different functions
        System.out.println("\ncapacity " + vec1.capacity() + "\ncontains " + vec1.contains("s") + "\nsize " + vec1.size() + "\nindexof" + vec1.indexOf("b") + "\nhashcode " + vec1.hashCode() + "\nget " + vec1.get(2) + "\nlistiterator.next " + vec1.listIterator().next() + "\ntostring " + vec1.toString());
        //use iterator
        System.out.println("printing as iterator");
        Iterator<String> itr1 = vec1.iterator();
        while (itr1.hasNext()) {
            System.out.print(itr1.next() + ' ');
        }
        System.out.println();
        //set
        Set<Person> set1 = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set1.add(new Person(i, "abcdefg".substring(i)));
        }
        set1.add(new Person(0, "abcdefg"));
        System.out.println("printing with foreach the set:");
        for (Person pI : set1
        ) {
            System.out.println(pI.toString());
        }

        //</editor-fold>
//<editor-fold desc="lesson 5 Home Work java collections>
        //set
        Set<Person> setPerson1 = new LinkedHashSet<>();
        setPerson1.add(new Person(1, "t"));
        setPerson1.add(new Person(1, "t"));
        System.out.println("num of elements in set: " + setPerson1.size());
        Iterator<Person> iterPerson1 = setPerson1.iterator();
        System.out.println("printing iterator of set Persons");
        while (iterPerson1.hasNext()) {
            System.out.println(iterPerson1.next().toString());
            //map
            Map<String, Integer> map1 = new LinkedHashMap<>();
            //-hasgmap is also an option
            map1.put("tehila", 0);
            map1.put("david", 1);
            map1.put("hodaya", 2);
            map1.put("sara", 3);
            System.out.println("printing from linked hashed map of map");
            for (Map.Entry<String, Integer> e : map1.entrySet()) {
                System.out.print(e + " ");
            }
            System.out.println("\nget: " + map1.get("tehila") + "\ncontainsKey: " + map1.containsKey("sara") + "\ncontainsVlaue: " + map1.containsValue(3) + "\nkeyset: " + map1.keySet() + "\nvalues: " + map1.values() + "\nentrySet: " + map1.entrySet());
//conllections
            Vector<Integer> vec = new Vector<>();
            for (int i = 0; i < 10; i++) {
                vec.add(i);
            }
            System.out.println("just the vec:" + vec);
            Collections.shuffle(vec);
            System.out.println("shuffle: " + vec);
            Collections.sort(vec);
            System.out.println("sort: " + vec);
            System.out.println("min: " + Collections.min(vec) + " max: " + Collections.max(vec) + " frequency of 0: " + Collections.frequency(vec, 0));
            Collections.reverse(vec);
            System.out.println("reverse: " + vec);
            Collections.swap(vec, 0, 2);
            System.out.println("swap index 0 with index 2: " + vec);


        }
//</editor-fold>
// <editor-fold desc="lesson 5 HomeWork Library Classes">
        HashMap<Integer, Book> bookHashMap = new HashMap<>();
        HashSet<Lend> lendHashSet = new HashSet<>();
        ArrayList<Customer> custumerArrayList = new ArrayList<Customer>();
        Book b1 = new Book("book0", 1), b2 = new Book("book1", 2), b3 = new Book("book2", 2);
//1. add to each collection
        bookHashMap.put(0, b1);
        bookHashMap.put(1, b2);
        bookHashMap.put(2, b3);
        custumerArrayList.add(new Customer("a"));
        custumerArrayList.add(new Customer("b"));
        custumerArrayList.add(new Customer("c"));

        lendHashSet.add(Lend.makeLend(0, bookHashMap, 0));

        lendHashSet.add(Lend.makeLend(1, bookHashMap, 1));
        lendHashSet.add(Lend.makeLend(2, bookHashMap, 2));
//2. search
        System.out.println("search: book-> " + bookHashMap.get(0));
        Iterator<Customer> iter1 = custumerArrayList.iterator();
        while (iter1.hasNext()) {
            if (iter1.next().getName() == "c") {
                iter1.remove();
                System.out.println("found in array list+remove by iter.remove()");
            }
        }
//3. remove
        if (bookHashMap.remove(0, b1)) System.out.println("removed b1 from books!");
        custumerArrayList.remove(0);
        lendHashSet.remove(new Lend(0, 0, new Date()));
//4.print
        for (Book b : bookHashMap.values()
        ) {
            System.out.print(" " + b);
        }
//5.sort:implement compareable
        Collections.sort(custumerArrayList);
        System.out.println("\nsorted customer list" + custumerArrayList);
//map functions
        System.out.println("map functions: get " + bookHashMap.get(1));
        Iterator<Map.Entry<Integer, Book>> iterator = bookHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().getName().startsWith("book2")) {
                System.out.println("remove book that starts with book2");
                iterator.remove();
            }
        }
        System.out.println("print: " + bookHashMap + " keys&values by entryset: " + bookHashMap.entrySet() + "keys: " + bookHashMap.keySet() + " values: " + bookHashMap.values());
//collections methods
        Vector<Integer> integerCollection = new Vector<>();
        for (int i = 0; i < 10; i++)
            integerCollection.add(i + 1);
        System.out.println("integers: " + integerCollection);
        Collections.sort(integerCollection);
        System.out.println("binaty seasrch of 3:" + Collections.binarySearch(integerCollection, 3));
        Collections.rotate(integerCollection, 3);
        System.out.println("rotate 3: " + integerCollection);
        System.out.println("n copies: " + Collections.nCopies(6, ":*)"));

        //</editor-fold>
        //<editor-fold desc="lesson 6 stream, lambda">
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
//====Stream =======יצירת
//1. Stream יצירת ריק
        // מחזירה סדרה ריקה//
        //  לדוגמא כדי להחזיר סדרה ריקה במקרה של אוסף ריק//
        Stream<String> streamEmpty = Stream.empty();
// יצירה מתוך אוסף . 2
        Stream<String> stList = strings.stream();
// יצירה מתוך מערך . 3
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stArray = Arrays.stream(arr);
        Stream<String> stArray1 = Arrays.stream(arr, 1, 3);
// נייצר באמצעות פונקציה. 4
        // נשים ערך התחלתי ונבצע פעולה עליו כמו לולאה עד עשרים//
        Stream<Integer> streamIter = Stream.iterate(40, n -> n + 2).limit(20);
// קריאה מקובץ. 5
        //  ניצור אובייקט מסוג נתיב כדי להשתמש בפעולה זו//
// Path pa = Paths.get("c:\\file.txt");
        //  נשתמש בפונקציה סטטית כדי לקרוא מתוך הקובץ ולייצר סטרים// //
// Stream<String> stFile = Files.lines(pa);
//====================================
        List<Person_2> persons = Arrays.asList(
                new Person_2("david", 33),
                new Person_2("yosi", 15),
                new Person_2("dani", 20),
                new Person_2("kobi", 15),
                new Person_2("beny", 10)
        );
        //  פעולות----//
        List<Person_2> filtered = persons
        //    יצירת סדרה של אלמנטים המאפשרים ביצוע פעולות רבות עליהם//
               .stream()
        //   סינון//
                 .filter(p -> p.getName().startsWith("d"))
        //     פעולה סופית האוספת את הערכים שעברו את הסינון לתוך אוסף//
           .collect(Collectors.toList());
        // ידפיס כל אובייקט ואובייקט מתוך האוסף//
        filtered.forEach(System.out::println);
        //  פעולות המחזירות ערך בוליאני------------//
        //          בודקת האם כל האלמנטים מקיימים את התנאי//
        boolean isAllMatched = persons.stream().allMatch(p -> p.getAge() < 18);
        //   בודקת אם יש מישהו שעונה לתנאי//
        boolean isAnyMatched = persons.stream().anyMatch(p -> p.getAge() < 18);
        System.out.println(isAllMatched + " " + isAnyMatched);
        //  פעולה שתחזיר אדם האדם המתאים לתנאי ואם לא תחזיר ערך ריק--//
        Person_2 p1 = persons.stream().filter(p -> p.getAge() < 17).findAny().orElse(null);
        //   -1-
        System.out.println(p1);
//=============map================
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        //  משמש לצורך ביצוע פעולה על כל אחד מאברי האוסף או החזרת חלק מהאובייקט//
        List<Integer> squIntegers = numbers.stream().map(x -> x *
                x).collect(Collectors.toList());
        //  ללא כפולים//
        List<Integer> squIntegers1 = numbers.stream().map(x -> x *
                x).distinct().collect(Collectors.toList());
        System.out.println(squIntegers);
        System.out.println(squIntegers1);
        // להחזיר ערך מסוים מתוך אובייקט//
        String fName = persons.stream().filter(p -> p.getAge() < 18)
                .map(p -> p.getName()).findFirst().orElse("");
        System.out.println(fName);
//==========פעולות חשבוניות============//
        Double avgAge = persons.stream().collect(Collectors.averagingDouble(p -> p.getAge()));
        System.out.println(avgAge);
        // מחלקה המאפשרת חישובים סטטיסטיים רבים//
        IntSummaryStatistics ageSummery = persons.stream()
                .collect((Collectors.summarizingInt(p -> p.getAge())));
        System.out.println(ageSummery.getAverage());
        System.out.println(ageSummery.getMax());
        System.out.println(ageSummery.getSum());
//==========grouping by===============
        //  מקבץ לפי קטגוריה של גילאים כשכל מקום הוא גיל ואוסף של אנשים//
        Map<Integer, List<Person_2>> personsByAge = persons.stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));
        personsByAge.keySet().forEach(System.out::println);
        Map<Integer, Long> personsByAge2 = persons.stream()
                .collect(Collectors.groupingBy(p -> p.getAge(), Collectors.counting()));
        personsByAge2.forEach((k, v) -> {
            System.out.println("age: " + k);
            System.out.println("the number of person is: " + v);
        });
        int even = numbers.stream().filter((x -> x % 2 == 0))
                .reduce(0, (ans, i) -> ans + i);
        System.out.println(even);
        String str = persons.stream().filter(p -> p.getAge() >= 18)
                .map(p -> p.getName())
                //     עוד דרך להחזיר בצורה מחרוזת ולא אוסף//
                .collect(Collectors.joining(" and ", "In Isreal ", " are of legal age."));
        System.out.println(str);
//}=
        //       ==================defualt functions in Interfaces==========
//        Car c = new Car();
//        c.Print();
    }

    public static Stream<String> func(List<String> list) {
        //    תפקיד הפונקציה היא לקבל אוסף מסוג מחרוזת ולהחזיר את הסדרה המקבילה לה//
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

}


