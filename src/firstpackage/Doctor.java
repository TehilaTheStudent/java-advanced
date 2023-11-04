package firstpackage;

public class Doctor extends Volunteer{

 private Title title;

    private Title getTitle() {
        return title;
    }
private int experience;
    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    protected int calcBonus() {
       return getBasisBonus()+experience+title.bonus;
    }

    public Doctor(PersonalDetails perDet, boolean taken, Days day, int basisBonus, Title title, int experience) {
        super(perDet, taken, day, basisBonus);
        this.title = title;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "\nDoctor{" +
                "title=" + title +
                ", experience=" + experience +
                "} " + super.toString();
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
