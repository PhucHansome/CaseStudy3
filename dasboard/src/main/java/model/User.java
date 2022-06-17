package model;

public class User {
    private long userId;
    private String userName;
    private String password;
    private String fullName;
    private long phone;
    private String email;
    private String address;
    private String Role;
    private String updateDate;
    private String createDate;
    private String img;

    public User(String userName, String password, String fullName, long phone, String email, String address, String role, String img) {
        this.userName =userName;
        this.password=password;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        Role = role;
        this.img = img;
    }

    ;

    public User(long userId, String userName, String password, String fullName, long phone, String email, String address, String role, String updateDate, String createDate) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        Role = role;
        this.updateDate = updateDate;
        this.createDate = createDate;
    }

    public User(long userId, String userName, String password, String fullName, long phone, String email, String address, String role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        Role = role;
    }

    public User(String userName ,String fullName, long phone, String email, String address, String roles, String createDate, String updateDate, String img) {
//        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.Role = roles;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
