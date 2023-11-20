package stream_lambda_collections_package;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Product {
    static int count=0;
    private int code;
    private String nameProduct;
    private double price;
    private int unitsInStack;

    @Override
    public String toString() {
        return " Product{" +
                "code=" + code +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", unitsInStack=" + unitsInStack +
                ", nameImporter='" + nameImporter + '\'' +
                "} ";
    }

    public Product(String nameProduct, double price, int unitsInStack, String nameImporter) {
        this.code = count++;
        this.nameProduct = nameProduct;
        this.price = price;
        this.unitsInStack = unitsInStack;
        this.nameImporter = nameImporter;
    }
public static List<Product>getProducts(){
    String[] importers = {"importer1", "importer2"};

    return Arrays.asList(
                new Product("shirt", 50, 3, importers[0]),
                new Product("shorts", 3, 34, importers[1]),
                new Product("sleeve", 94, 12, importers[0]),
                new Product("hat", 17, 71, importers[0]),
                new Product("shoes", 943, 1, importers[1]),
                new Product("socks", 38, 0, importers[1]),
                new Product("jeans", 18, 23, importers[1]),
                new Product("shoelace", 68, 86, importers[1]),
                new Product("scarf", 3, 5, importers[0]),
                new Product("gloves", 7, 92, importers[0])
        );
}
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnitsInStack() {
        return unitsInStack;
    }

    public void setUnitsInStack(int unitsInStack) {
        this.unitsInStack = unitsInStack;
    }

    public String getNameImporter() {
        return nameImporter;
    }

    public void setNameImporter(String nameImporter) {
        this.nameImporter = nameImporter;
    }

    private String nameImporter;
}
