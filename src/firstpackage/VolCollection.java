package firstpackage;

import java.util.Arrays;


public class VolCollection {
    private Volunteer [] arrv=new Volunteer[5];
    private int index=0;
    public void addVolunteer(Volunteer newVol){
        if (index<arrv.length){
            arrv[index++]=newVol;
        }
        else{
            System.out.println("no space for "+newVol.getPerDet().getFirstName()+" to join the collction");
        }
    }
    public Volunteer search(int type, int minage, Volunteer.Days day){
        for (Volunteer i:arrv) {
      if(type==1&&i instanceof Doctor&&i.getPerDet().getAge()>minage&&i.getDay()== day){
          i.setTaken(true);
          return i;
      }
        }
        return null;
    }

    @Override
    public String toString() {
        return "VolCollection{" +
                "arrv=" + Arrays.toString(arrv) +
                '}';
    }
    public void printInOrder(){
        Arrays.sort(arrv,0,index--);
        System.out.println(Arrays.toString(arrv));
    }
}
