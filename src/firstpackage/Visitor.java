package firstpackage;

public class Visitor extends Volunteer{




    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    protected int calcBonus() {
        return getBasisBonus()+ state.bonus;
    }

    @Override
    public String toString() {
        return "\nVisitor{" +
                "state=" + state +
                "} " + super.toString();
    }

    public Visitor(PersonalDetails perDet, boolean taken, Days day, int basisBonus, State state) {
        super(perDet, taken, day, basisBonus);
        this.state = state;
    }

}
