import java.util.ArrayList;
import java.util.List;
public class Products {
    private String id;
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;


     Products(String id, String productName, int quantity, double price, double totalPrice) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }
    Products(String id, String productName, int quantity, double price) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static void displayFormat(){
        System.out.format("-----------------------------------------------------------------------");
        System.out.println("\nProduct ID \t\tName\t\t\t Rate\t\t\t Quantity");
        System.out.format("-----------------------------------------------------------------------");
    }

    //display

    public void display(){
        System.out.format("%5s %17s %14s %20s\n", id, productName, quantity, price, totalPrice);
    }

    public static void displayProductFormat(){
        System.out.println("---------------------------Product List---------------------------");
        System.out.format("-----------------------------------------------------------------");
        System.out.println("\nProduct ID \t\tProduct Name \t  Rate\t\t\tQuantity");
        System.out.format("-----------------------------------------------------------------\n");
    }

    //Display Product
    public void displayProducts(){
        System.out.format("%5s %17s %14s %20s\n", id, productName, price, quantity);
    }

    public static List<Products> addProducts(){
        List<Products> products = new ArrayList<>();
        products.add(new Products("1", "Chocolate", 100, 20.0));
        products.add(new Products("2", "Chips", 200, 25.0));
        products.add(new Products("3", "Soap", 50, 10.0));
        products.add(new Products("4", "Battery", 20, 30.0));
        products.add(new Products("5", "Noodles", 60, 10.0));
        products.add(new Products("6", "Ice Cream", 50, 50.0));
        return products;
    }


}
