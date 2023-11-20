package Model_package;

public class HardwareProduct extends Product{
    private int warrantryPeriod;

    public HardwareProduct(long id, String name, String description, float pricePerUnit, int warrantryPeriod) {
        super(id, name, description, pricePerUnit);
        this.warrantryPeriod = warrantryPeriod;
    }

    @Override
    public float getPrice() {
        return warrantryPeriod+getPricePerUnit();
    }

    public int getWarrantryPeriod() {
        return warrantryPeriod;
    }

    public void setWarrantryPeriod(int warrantryPeriod) {
        this.warrantryPeriod = warrantryPeriod;
    }
public enum Types{
        SOFTWARE,HARDWARE
    }
}
