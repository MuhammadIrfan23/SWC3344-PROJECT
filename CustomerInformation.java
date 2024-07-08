import java.util.*;

public class CustomerInformation {
    private String sCustId;
    private String sCustName;
    private int iTableNumber;
    
    LinkedList <OrderInformation> customerList = new LinkedList();
    
    public CustomerInformation() {
        sCustId = null;
        sCustName = null;
        iTableNumber = 0;
    }
    
    //mutator
    public void setCustomerId(String sId) {
        sCustId = sId;
    }
    public void setCustomerName(String sN) {
        sCustName = sN;
    }
    public void setTableNumber(int iT) {
        iTableNumber = iT;
    }
    
    //mutator for all
    public void setAll(String sId, String sN, int iT) {
        sCustId = sId;
        sCustName = sN;
        iTableNumber = iT;
    }
    
    //accessor
    public String getCustomerId() {
        return sCustId;
    }
    public String getCustomerName() {
        return sCustName;
    }
    public int getTableNumber() {
        return iTableNumber;
    }
    
    public LinkedList <OrderInformation> getOrders() {
        return customerList;
    }
}