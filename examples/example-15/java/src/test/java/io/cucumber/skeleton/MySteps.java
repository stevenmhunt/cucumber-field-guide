package io.cucumber.skeleton;

import io.cucumber.skeleton.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.DataTableType;
import java.util.List;
import java.util.Map;

public class MySteps {

    @DataTableType
    public User users(Map<String, String> entry) {
        return new User(
            entry.get("id"),
            entry.get("name"));
    }

    @Given("the following users are created:")
    public void the_following_users_are_created(List<User> users) {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}