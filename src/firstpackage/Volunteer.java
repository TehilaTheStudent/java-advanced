package firstpackage;
enum Days{
    SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY, FRIDAY  ;
}

public abstract class Volunteer implements Comparable<Volunteer>{
    @Override
    public int compareTo(Volunteer o) {
        return this.getPerDet().getFirstName().charAt(0)-o.getPerDet().getFirstName().charAt(0);
    }

    private PersonalDetails perDet;
    private boolean taken;
    private Days day;
    private int basisBonus;

    public Volunteer(PersonalDetails perDet, boolean taken, Days day, int basisBonus) {
        this.perDet = perDet;
        this.taken = taken;
        this.day = day;
        this.basisBonus = basisBonus;
    }

    public PersonalDetails getPerDet() {
        return perDet;
    }

    public void setPerDet(PersonalDetails perDet) {
        this.perDet = perDet;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
    }

    public int getBasisBonus() {
        return basisBonus;
    }

    public void setBasisBonus(int basisBonus) {
        this.basisBonus = basisBonus;
    }

    @Override
    public String toString() {
        return "\nVolunteer{" +
                "perDet=" + perDet +
                ", taken=" + taken +
                ", day=" + day +
                ", basisBonus=" + basisBonus +
                '}';
    }
   protected abstract int calcBonus();


}

