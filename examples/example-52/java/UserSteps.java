import io.cucumber.java.en.*;
import org.jooq.Record;
import static org.jooq.impl.DSL.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserSteps {
    private CustomWorld world;

    public UserSteps(CustomWorld world) {
        this.world = world;
    }

    @Given("a user is created with name {string}")
    public void aUserIsCreatedWithName(String name) {
        world.getDBContext().insertInto(table("users"), field("name"))
              .values(name)
              .execute();
    }

    @Then("a user with name {string} should exist")
    public void aUserWithNameShouldExist(String expectedName) {
        Record record = world.getDBContext().selectFrom(table("users"))
                              .where(field("name").eq(expectedName))
                              .fetchOne();
        assertEquals(expectedName, record.getValue(field("name"), String.class));
    }
}