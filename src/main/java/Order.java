import java.util.ArrayList;
import java.util.Date;

public class Order {
    public
    int orderId ;
    int customerId;
    ArrayList<String> Products = new ArrayList<>();
    Double Totalamount;
    int ProductId;
    Date StartDate = new Date();
    Date EndDate = new Date();
    Order(int id ){
        orderId=id;
        // costumerId=costid;
        //   Totalamount=amount;
        //   ProductId=prodid;
        //   StartDate=start;
        //   EndDate=End;
    }
    void NumofOrders (Date Start , Date End){
        //search in list and count
    }
    void viewOrdersDetails(){
        //print order details : address order phone email id
    }
    void PlaceOrder(){
        // confirm order -> go to payment
    }
    //ay betngan
}
