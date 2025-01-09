require 'selenium-webdriver'

Before('@webdriver') do
    options = Selenium::WebDriver::Firefox::Options.new
    @driver = Selenium::WebDriver.for(
        :remote,
        url: 'http://localhost:4444/wd/hub',
        capabilities: options
    )
end

After('@webdriver') { @driver.quit }