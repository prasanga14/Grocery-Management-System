public class Customer {
    private String id;
    private  String customerName;
    private String address;

    public Customer(String id, String customerName, String address){
        this.id = id;
        this.customerName = customerName;
        this.address = address;

    }
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }


    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;

    }
}
