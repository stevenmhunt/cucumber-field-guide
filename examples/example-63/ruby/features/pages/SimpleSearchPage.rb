require 'selenium-webdriver'

class SimpleSearchPage
    def initialize(driver, base_url)
        @driver = driver
        @url = "#{base_url}/index.html"
        @search_box_locator = { id: 'search_box' }
        @results_locator = { id: 'results' }
    end

    def open
        @driver.navigate.to @url
    end

    def type_search(query)
        wait = Selenium::WebDriver::Wait.new(timeout: 10)
        wait.until { @driver.find_element(@search_box_locator).displayed? }
        search_box = @driver.find_element(@search_box_locator)
        search_box.clear
        search_box.send_keys(query)
    end

    def submit_search
        wait = Selenium::WebDriver::Wait.new(timeout: 10)
        wait.until { @driver.find_element(@search_box_locator).displayed? }
        search_box = @driver.find_element(@search_box_locator)
        search_box.submit
    end

    def results_text
        wait = Selenium::WebDriver::Wait.new(timeout: 10)
        wait.until { @driver.find_element(@results_locator).displayed? }
        results_area = @driver.find_element(@results_locator)
        results_area.text
    end
end