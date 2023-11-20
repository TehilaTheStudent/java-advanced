package Exception_package;

import Person_package.Person;

public class DetailsException extends Exception{
    private int number;
    public static void createPersonWithExceptions (int id,String name)throws DetailsException{
    rollException(id,name);
    }
   public static void rollException(int id,String name) throws DetailsException{
       DetailsException detailsException1;
       if(Integer.toString(id).length()!=9)
           throw  new DetailsException(2);
       else
       if(name.length()<3)
           throw  new DetailsException(3);
       else
       if(!(name.charAt(0)>=65&&name.charAt(0)<=90))
           throw new DetailsException(1);

       Person person1=new Person(id,name);
       System.out.println("person was created! "+person1.toString());
   }
    public DetailsException(int number) {
        super("the message of the exception from Exception");
        System.out.println("a DetailsException object is being created!");
this.number=number;
    }
    public void printMessage(){
        switch (number){
            case  1:
                System.err.println("name must start with a capital letter");
                break;
            case 2:
                System.err.println("id must be 9 number long");
                break;
            case 3:
                System.err.println("name cant be a one letter short");
        }
    }
}
