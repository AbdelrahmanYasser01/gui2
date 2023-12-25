import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User{
    //comment
    private
    String CustomerName;
    String address;
    String Email;
    String Phonenum;
    int CustomerId;
    int CartId;
    ArrayList<String> Products = new ArrayList<>();
    Double Totalamount;
    int numoforders;
    //ArrayList<String> orders;
    Order[] order = new Order[numoforders];
    private ArrayList<Product> Cart = new ArrayList<>();

    public Customer(int id, String Name, String location, String email, String phone, String Password, UserType user) {
        super(id, Password, user);
        CustomerName = Name;
        address = location;
        Email = email;
        Phonenum = phone;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhonenum() {
        return Phonenum;
    }

    public void setPhonenum(String phonenum) {
        Phonenum = phonenum;
    }

    public int getCartId() {
        return CartId;
    }

    public void setCartId(int cartId) {
        CartId = cartId;
    }

    public ArrayList<String> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<String> products) {
        Products = products;
    }

    public Double getTotalamount() {
        return Totalamount;
    }

    public void setTotalamount(Double totalamount) {
        Totalamount = totalamount;
    }

    public int getNumoforders() {
        return numoforders;
    }

    public void setNumoforders(int numoforders) {
        this.numoforders = numoforders;
    }

    public Order[] getOrder() {
        return order;
    }

    public void setOrder(Order[] order) {
        this.order = order;
    }

    public ArrayList<Product> getCart() {
        return Cart;
    }

    public void setCart(ArrayList<Product> cart) {
        Cart = cart;
    }

    Order DetailedOrders(int CostId) {
        //search in list and print the orders
        for (Order order : order) {
            if (order.customerId == CostId) {
                return order; // Found the order
            }
        }
        return null;
    }

    // view a specific order
    Order viewOrder(int ordId) {
        for (Order ord : order) {
            if (ord.orderId == ordId) {
                return ord; // Found the order
            }
        }
        /* view order */
        return null;
    }

    void CreateCart() {
        orders.add(String.valueOf(Cart));
    }

    void CancelCart() {
        orders.remove(String.valueOf(Cart));
    }
    //
    void addToCart(Product product) {
        Cart.add(product);
    }

    void RemoveFromCart(Product product) {
        if(Cart.contains(product)){
            Cart.remove(product);
        }
        else System.out.println("   !product is not in cart!   ");
    }

    public List<Product> searchProd(String searchField) {
        List<Product> search = new ArrayList<>();
        for (String productData : Products) {
            Product product = Product.parse(productData);
            if (product != null && product.getName().toLowerCase().contains(searchField.toLowerCase())) {
                search.add(product);
            }
        }
        return search;
    }
    ArrayList<Product> ViewCart() {
        return Cart; // not sure
    }

    void MakePayment(Order order) {
        System.out.println("Total amount : " + Totalamount);
        System.out.println("Cash on delivery");
        System.out.println("Confirm order");
        Scanner s = new Scanner(System.in);
        String confirm = s.nextLine();
        if (confirm != "yes") {
            CancelCart();
        } else {
            order.PlaceOrder();
            System.out.println("order is confirmed");
        }
    }


    public static Customer parse(String data) {
        String[] parts = data.split(",");
        if (parts.length < 6) {
            throw new IllegalArgumentException("Invalid data format: " + data);
        }
        int customerID = Integer.parseInt(parts[0].trim());
        String customerName = parts[1];
        String Address = parts[2];
        String email = parts[3];
        String phone = parts[4];
        String password = parts[5];
        UserType user = UserType.Customer;


        return new Customer(customerID, customerName, Address, email, phone, password, user);

    }
    @Override
    public String toString() {
        return this.getid() + "," + this.CustomerName + "," + this.address + "," + this.Email + "," + this.Phonenum + "," + this.password;
    }

    public static int generateRandomID() {

        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
