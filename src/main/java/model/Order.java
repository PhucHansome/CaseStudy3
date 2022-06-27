package model;

public class Order {
    private long orderId;
    private String fullName;
    private String email;
    private String phone;
    private String orderDate;
    private String deliveryAddress;
    private String grandTotal;
    private String createDate;
    private String updateDate;
    private long userId;

    public Order(long orderId, String fullName, String email, String phone, String orderDate, String deliveryAddress, String grandTotal, String createDate, String updateDate, long userId) {
        this.orderId = orderId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.orderDate = orderDate;
        this.deliveryAddress = deliveryAddress;
        this.grandTotal = grandTotal;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.userId = userId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
