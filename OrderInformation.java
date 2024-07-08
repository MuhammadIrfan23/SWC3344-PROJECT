public class OrderInformation {
    private String sOrderId;
    private String sItemName;
    private double dItemPrice;
    private int iQuantity;
    private String sOrderTime;
    
    public OrderInformation() {
        sOrderId = null;
        sItemName = null;
        dItemPrice = 0.0;
        iQuantity = 0;
        sOrderTime = null;
    }
    
    //mutator
    public void setOrderId(String sO) {
        sOrderId = sO;
    }
    public void setItemName(String sI) {
        sItemName = sI;
    }
    public void setItemPrice(double dP) {
        dItemPrice = dP;
    }
    public void setQuantity(int iQ) {
        iQuantity = iQ;
    }
    public void setOrderTime(String sT) {
        sOrderTime = sT;
    }
    
    public void setAll(String sO, String sI, double dP, int iQ, String sT) {
        sOrderId = sO;
        sItemName = sI;
        dItemPrice = dP;
        iQuantity = iQ;
        sOrderTime = sT;
    }
    
    //accessor
    public String getOrderId() {
        return sOrderId;
    }
    public String getItemName() {
        return sItemName;
    }
    public double getItemPrice() {
        return dItemPrice;
    }
    public int getQuantity() {
        return iQuantity;
    }
    public String getOrderTime() {
        return sOrderTime;
    }
}