package MySelfLearning;

import java.util.*;
import java.util.stream.Collectors;

public class Values<T> {
    private T valueT;

    public Values(T valueT) {
        this.valueT = valueT;
    }
public void tellUs(){
    System.out.println("valueT is obj of: "+valueT.getClass());
}
    public T getValueT() {
        return valueT;
    }

    public void setValueT(T valueT) {
        this.valueT = valueT;
    }
    public static void rawMethod(Values v1){
        System.out.println(v1.valueT.getClass());
    }
    public  static  <S> ArrayList<S> statucParamMethod(){
return new ArrayList<S>();
    }


    public <U> void paramMethod(U u,Values<T> v1) {
Integer i1=new Integer(9);
        if (valueT instanceof Number)
            System.out.println("yes");
        else System.out.println("no");
    }
    public  <U extends Collection>void boundedMethod(U ui){
        System.out.println(Collections.class.getName()+" is super of "+ui.getClass());
    }
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }


}
