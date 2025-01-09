require 'screengem'
require 'rspec'

module Questions
    class ResultsText < Screengem::Question
        def initialize(expected)
            super
            @expected = expected
        end

        def execute
            browser = actor.recall('browser')
            page = SimpleSearchPage.new(browser.driver, browser.base_url)
            expect(page.results_text).to eq(@expected)
        end
    end
end