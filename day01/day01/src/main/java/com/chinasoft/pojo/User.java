package com.chinasoft.pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String address;
    private String email;
    private int c_id;

    public User(){
        super();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getC_id() {
        return c_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", c_id=" + c_id +
                '}';
    }

    public User(int id, String username, String password, String phone, String address, String email, int c_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.c_id = c_id;
    }
}
