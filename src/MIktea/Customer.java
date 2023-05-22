package MIktea;

import java.io.Serializable;
public class Customer implements Serializable {
    private String ID;
    private String ProductName;
    private int Quanity;

    private int Price;

    public Customer(String ID, String productName, int quanity, int price) {
        this.ID = ID;
        ProductName = productName;
        Quanity = quanity;
        Price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuanity() {
        return Quanity;
    }

    public void setQuanity(int quanity) {
        Quanity = quanity;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
