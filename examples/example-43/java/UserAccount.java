package io.cucumber.skeleton;

public class UserAccount {
    private String name;
    private String email;
    private String city;
    private String state;
    private String phone;

    public UserAccount(String name, String email, String city, String state, String phone) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.state = state;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
}
