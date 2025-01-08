package io.cucumber.skeleton;

import com.github.javafaker.Faker;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.cucumber.skeleton.UserAccount;

public class UserAccountGenerator {

    public static UserAccount generateUserAccount() {
        Faker faker = new Faker();        
        String name = faker.name().fullName();
        String city = faker.address().city();
        String state = faker.address().state();
        String phone = faker.phoneNumber().phoneNumber();

        String emailLocalPart = name.toLowerCase().replace(" ", ".");
        emailLocalPart = emailLocalPart.replaceAll("[^a-z0-9.]", "");
        String email = emailLocalPart + "@sink.mywebsite.com";        

        return new UserAccount(name, email, city, state, phone);
    }
}