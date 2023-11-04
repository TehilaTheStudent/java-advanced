package firstpackage;
import CollenctionsPackage.GlobalCollection;
import CollenctionsPackage.Person;

import java.lang.reflect.*;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
      //  <editor-fold-desc="2nd lesson hw page 1 2 3 4 volunteers">
Doctor d1=new Doctor(new PersonalDetails("034536615",40,"Penina","Aharonovich"),false,Days.FRIDAY,30,Title.APPRENTICE,2);
        Doctor d2=new Doctor(new PersonalDetails("325931301",18,"Tehila","Aharonovich"),false,Days.THURSDAY,10,Title.NURSE,2);
Visitor v1=new Visitor(new PersonalDetails("335388682",12,"Avigail","Aharonovich"),false,Days.WEDNESDAY,39,State.SINGLE);
Visitor v2=new Visitor(new PersonalDetails("034331485",41,"Naftali","Aharonovich"),false,Days.MONDAY,88,State.MARRIED);

//hw pages 1&2
        for (State si:State.values() ) {
            System.out.println("ordinal "+si.ordinal()+"name "+si.name());
        }
        for (Days di:Days.values() ) {
            System.out.println("ordinal "+di.ordinal()+"name "+di.name());
        }
        for (Title i :Title.values() ) {
            System.out.println("ordinal "+ i.ordinal()+"name "+ i.name());
        }
        System.out.println("d1 bonus:"+d1.calcBonus());
        System.out.println("d2 bonus:"+d2.calcBonus());
        System.out.println("v1 bonus:"+v1.calcBonus());
        System.out.println("v2 bonus:"+v2.calcBonus());
     //   hw pages 3&4
VolCollection vc1=new VolCollection();
vc1.addVolunteer(v1);
vc1.addVolunteer(v2);
vc1.addVolunteer(d1);
vc1.addVolunteer(d2);
      Volunteer volunteer = vc1.search(1,13,Days.SUNDAY);
        if (volunteer == null) {
            System.out.println("null, didnt find any volunteer");
        } else {
            System.out.println("found "+volunteer.getPerDet().getFirstName());
       }
//</editor-fold>
//<editor-fold-desc="3rd lesson reflection">
Rectangle rectObj1 = new Rectangle();
        Class rectClass1= rectObj1.getClass();
        Class<Box> boxClass2=Box.class;
        try {
            Class volunteerClass1=Class.forName("firstpackage.Volunteer");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("toString: "+rectClass1.toString()+"\ngetSimpleName: "
                +rectClass1.getSimpleName()+ "\ngetTypeName: "+
                rectClass1.getTypeName()+"\ngetPackageName: "+rectClass1.getPackageName()
        +"\ngetName: "+rectClass1.getName()+"\ngetCanonicalName: "+rectClass1.getCanonicalName()
        +"\ndescriptorString: "+rectClass1.descriptorString()+"\ntoGeneticString: "+rectClass1.toGenericString());
        System.out.println("getModofiers"+Modifier.toString( rectClass1.getModifiers()));
        System.out.println("getSuperClass: "+boxClass2.getSuperclass().getSimpleName());

        try {
            System.out.println("newInstance: "+rectClass1.newInstance().toString());
            // Use the newly created instance as needed

        } catch (InstantiationException e) {
            // Handle InstantiationException
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            // Handle IllegalAccessException
            e.printStackTrace();
        }
        for(Field fi:rectClass1.getFields()) {
            System.out.println("fields: name "+fi.getName()+" type "+fi.getType().getSimpleName()+" modifier "+Modifier.toString(fi.getModifiers()));
        }
        for (Method mi:rectClass1.getDeclaredMethods()) {
            System.out.println("methods: name "+mi.getName()+" parameter count "+mi.getParameterCount()+" returns "+mi.getReturnType().getSimpleName());
        }
        for(Constructor ci:rectClass1.getDeclaredConstructors()){
            System.out.println("constructors: name "+ci.getName()+" parameter types"+Arrays.toString(ci.getParameterTypes()));
        }
        Class personalDetailsClass1= PersonalDetails.class;
        try {
            PersonalDetails personalDeilsObj1= (PersonalDetails)  personalDetailsClass1.getConstructor(null).newInstance();
    personalDeilsObj1.getClass().getDeclaredFields()[0].set(personalDeilsObj1,"string");
personalDeilsObj1.getClass().getMethod("setId", String.class).invoke(personalDeilsObj1,"put id using reflection");
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

//        GlobalCollection <Integer>gbInt =new GlobalCollection<>();
//        for (int i = 0; i< gbInt.toArray().length; i++){
//            gbInt.add(10-i);
//        }
//        GlobalCollection <String>gbString=new GlobalCollection<>();
//        for (int i = 0; i< gbString.toArray().length; i++){
//            gbString.add("abcdefg".substring(0,"abcdefg".length()-i));
//        }
//        GlobalCollection <Person>gbPerson=new GlobalCollection<>();
//        for (int i=0;i<gbPerson.toArray().length-1;i++){
//            gbPerson.add(new Person(12-i,"Tehila"));
//        }
//        gbPerson.add(new Person(11,"Tehila"));
//        //use printSort
//        gbInt.printSort();
//        gbString.printSort();
//        gbPerson.printSort();
//       //use remove
//        gbPerson.remove(gbPerson.toArray()[2]);
//        gbPerson.printAll();
//        //use full clear toString
//        gbPerson.add(new Person(123,"Tili"));
//        System.out.println(    gbPerson.toString());
//
//        if(gbPerson.isFull()){
//            System.out.println("clearing because its full");
//        gbPerson.clear();}
//        System.out.println("is empty? "+gbPerson.isEmpty());
//        //use equals
//        GlobalCollection<String> gb1=new GlobalCollection<>();
//        gb1.add("abc");
//        GlobalCollection<String> gb2=new GlobalCollection<>();
//        gb2.add("abc");
//        System.out.println("are equals? "+gb1.equals(gb2));
        GlobalCollection <Integer> gb=new GlobalCollection<>();
        Integer [] arr=gb.toArray();
       System.out.println(gb.toArray().length);

        //</editor-fold>

    }
}
