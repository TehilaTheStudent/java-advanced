package firstpackage;

public enum Title{
    PROFESSOR(100),
    APPRENTICE(10),
    NURSE(25),
    SURGEON(75);
    int bonus;
    Title(int bonus){this.bonus=bonus;}
}
