const { Given, When, Then } = require('@cucumber/cucumber');
const { Navigate, Enter, Click, Text, PageElement, By } = require('@serenity-js/web');
const { Ensure, includes } = require('@serenity-js/assertions');

Given('the homepage is opened with screenplay', function () {
    return this.actor.attemptsTo(
        Navigate.to('http://localhost:9999')
    );
});

When('{string} is typed into the search box with screenplay', function (text) {
    return this.actor.attemptsTo(
        Enter.theValue(text).into(PageElement.located(By.css('input[type="text"]')))
    );
});

When('the {string} button is pressed with screenplay', function (btn) {
    return this.actor.attemptsTo(
        Click.on(PageElement.located(By.css(`input[type="submit"][value="${btn}"]`)))
    );
});

Then('the results should display {string} with screenplay', function (expectedText) {
    return this.actor.attemptsTo(
        Ensure.that(
            Text.of(PageElement.located(By.css('div#results'))),
            includes(expectedText))
    );
});