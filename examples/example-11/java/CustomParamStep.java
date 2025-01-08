import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.java.en.When;

public class CustomParamStep {
    @ParameterType("\\d{4}-\\d{2}-\\d{2}")
    public LocalDate isoDate(String date) {
        return LocalDate.parse(date);
    }
    @When("the user selects the date {isoDate}")
    public void the_user_selects_the_date_isodate(LocalDate date) {
        // do something with the date...
    }
}