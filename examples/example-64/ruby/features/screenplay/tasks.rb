require 'screengem'

module Tasks
    class OpenBrowser < Screengem::Task
        def execute
            browser = actor.recall('browser')
            page = SimpleSearchPage.new(browser.driver, browser.base_url)
            page.open
        end
    end

    class TypeSearch < Screengem::Task
        def initialize(text)
            super
            @text = text
        end

        def execute
            browser = actor.recall('browser')
            page = SimpleSearchPage.new(browser.driver, browser.base_url)
            page.type_search(@text)
        end
    end

    class SubmitSearch < Screengem::Task
        def execute
            browser = actor.recall('browser')
            page = SimpleSearchPage.new(browser.driver, browser.base_url)
            page.submit_search
        end
    end
end
