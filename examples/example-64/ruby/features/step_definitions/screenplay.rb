Given('the homepage is opened with screenplay') do
    @actor.performs(Tasks::OpenBrowser.new)
end

When('{string} is typed into the search box with screenplay') do |value|
    @actor.performs(Tasks::TypeSearch.new(value))
end

When('the {string} button is pressed with screenplay') do |btn|
    @actor.performs(Tasks::SubmitSearch.new)
end

Then('the results should display {string} with screenplay') do |results|
    @actor.asks(Questions::ResultsText.new(results))
end