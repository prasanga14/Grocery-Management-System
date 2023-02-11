import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Billing {
    // Importing array from Products class and storing it to productsList
   public static List<Products> productsList = Products.addProducts();
    public static void main(String[] args) {
        //Declaring Variables and setting default values
        String id = null;
        int quantity = 0;
        double price = 0.0;
        double totalPrice = 0.0;
        double overAllPrice = 0.0;
        double subtotal = 0.0, discount = 0.0;
        // This is the null value for character
        char choice = '\0';

        Products.displayProductFormat();

        for (int i = 0; i < productsList.size(); i++){
            productsList.get(i).displayProducts();
        }
        System.out.println("-----------------------------------------------------------------------");
        // Creating Scanner class to get customer information
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Customer Address: ");
        String customerAddress = scanner.nextLine();

        Customer customer = new Customer(customerId, customerName, customerAddress);

        System.out.println("\t\t\t\t------------------Invoice----------------");
        System.out.println("\t\t\t\t\t"+ "     " + "\tA to Z Grocery Store");
        System.out.println("\t\t\t\t\t"+ "     " + "\tBalaju-21, Kathmandu");
        System.out.println("Name: " + customer.getCustomerName() + "\n" + "Address: " + customer.getAddress());

        // Creating a ArrayList to store items selected by customer
        List<Products> productArrCustomer = new ArrayList<>();

        do{
            Scanner scan = new Scanner(System.in);

            // Take input values from User

            System.out.println("Enter Product ID: ");
            id = scan.nextLine();

            System.out.println("Enter Quantity");
            quantity = scan.nextInt();

            //Calculate the total amount for each product i.e. quantity * price

            totalPrice = getTotalPrice(productsList, id, quantity);

            if(totalPrice < 0){

                if(totalPrice == -2){
                    System.out.println("Quantity Exceeeds Available Stock");
                }

                if(totalPrice == -1){
                    System.out.println("No Product with ID " + id + "found");
                }
                continue;
            }

            // Calculate Overall Price
            overAllPrice = overAllPrice + totalPrice;

            //Create product object and add it to the list
            buildProductsObject(id, quantity, totalPrice, productsList, productArrCustomer);

            // Ask to add more products
            System.out.println("Want to add products (y / n): ");
            choice = scan.next().charAt(0);
            scan.nextLine();

            Products.displayProductFormat();

            for (int i = 0; i < productsList.size(); i++){
                productsList.get(i).displayProducts();
            }

            System.out.println("--------------------------------------------------------------------------\n");
        }
        while (choice == 'Y' || choice == 'y');

        // Display all products with their properties
        Products.displayProductFormat();
        for (int i = 0; i < productsList.size(); i++){
            productsList.get(i).displayProducts();
        }

        //Price Calculation
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t  Total Amount(Rs.)" + overAllPrice);

        //Calculating Discount
        discount = overAllPrice * 0.03;
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t  Discount Amount(Rs.)" + discount);

        //Total amount after discount
        subtotal = overAllPrice - discount;

        // Final amount for customer to pay
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t Invoice Total(Rs.)" + subtotal);

        System.out.println("\t\t--------------ThankYou for Shopping------------- ");

    }

    //Function to build product object selected by customer
    private static void buildProductsObject(String id, int quantity, double totalPrice, List<Products> productsList, List<Products> products ){
            for (int i = 0; i < productsList.size(); i++){
                if (productsList.get(i).getId().equals(id)){
                    products.add(new Products(id, productsList.get(i).getProductName(), quantity, productsList.get(i).getPrice(), totalPrice));
                }
            }
    }

    private static double getTotalPrice(List<Products> productsList, String id, int quantity){
    for (int i = 0; i < productsList.size(); i++){
       if( productsList.get(i).getId().equals(id)){
           if(productsList.get(i).getQuantity() > quantity){
               reduceProductQuantityFromStock(i, productsList.get(i), quantity);
               return productsList.get(i).getPrice() * quantity;
           }else {
               // If product stock is less than quantity asked by customer
               return -2;
           }
       }
    }
    // If the product id does not exist
    return -1;
    }

    //Function to reduce stock quantity from products array
    public static void reduceProductQuantityFromStock(int index, Products products, int quantity){
        products.setQuantity(products.getQuantity() - quantity);
        productsList.set(index, products);
    }

}
