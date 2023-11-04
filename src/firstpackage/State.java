package firstpackage;

public enum State {
    LARGE(100),
    SINGLE(10),
    MARRIED(25),
    PREGNANT(75);
    int bonus;
    State(int bonus){this.bonus=bonus;}
}
