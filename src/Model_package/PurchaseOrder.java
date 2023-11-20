package Model_package;

import java.time.LocalDate;
import java.util.ArrayList;

public class PurchaseOrder <T extends Product>{
    private Customer orderingCustomer;
   private ArrayList<T> productsList;
private LocalDate orderDate;
    public PurchaseOrder(Customer orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
        productsList = new ArrayList<>();
        orderDate=LocalDate.now();
    }

    public Customer getOrderingCustomer() {
        return orderingCustomer;
    }

    public void setOrderingCustomer(Customer orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
    }

    public ArrayList<T> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<T> productsList) {
        this.productsList = productsList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "orderingCustomer=" + orderingCustomer +
                ", productsList=" + productsList +
                ", orderDate=" + orderDate +
                "} ";
    }
}
