require 'rspec'

Given('the homepage is opened with webdriver') do
    @simple_search = SimpleSearchPage.new(@driver, 'http://localhost:9999')
    @simple_search.open
end

When('{string} is typed into the search box with webdriver') do |value|
    @simple_search.type_search(value)
end

When('the {string} button is pressed with webdriver') do |btn|
    @simple_search.submit_search
end

Then('the results should display {string} with webdriver') do |results|
    expect(@simple_search.results_text).to eq(results)
end