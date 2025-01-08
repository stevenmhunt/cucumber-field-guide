package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.skeleton.CustomWorld;

public class MySteps {
    private CustomWorld world;

    public MySteps(CustomWorld world) {
        this.world = world;
    }

    @Given("the user adds {int} items to the cart")
    public void the_user_adds_int_items_to_the_cart(int count) {
        this.world.addItems(count);
    }
}