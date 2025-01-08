package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assumptions;

public class Hooks {
    private static Map<String, Integer> failedFilters = new HashMap<String, Integer>();
    private static final int THRESHOLD = 1;

    private String getTagFilter(Scenario scenario) {
        return scenario.getSourceTagNames().stream()
            .filter(tag -> tag.indexOf("@feature_") == 0).findFirst().orElse(null);
    }

    @Before
    public void checkIfSkip(Scenario scenario) {
        String f = getTagFilter(scenario);
        if (failedFilters.containsKey(f) && failedFilters.get(f) >= THRESHOLD) {
            Assumptions.assumeTrue(false); // For JUnit 4 use Assume.assumeTrue
        }
    }

    @After
    public void checkTestResult(Scenario scenario) {
        if (scenario.isFailed()) {
            String f = getTagFilter(scenario);
            failedFilters.put(f,
                (failedFilters.containsKey(f) ? failedFilters.get(f) : 0) + 1);
        }
    }
}