public class Steps extends TransformableSteps {
    @Given("the user adds {int} items")
    public void the_user_adds_n_items(int items) {
        transformer((Integer _items, Integer extra1) -> {
            // your step definition code goes here.
        }).accept(items, null);
    }
}