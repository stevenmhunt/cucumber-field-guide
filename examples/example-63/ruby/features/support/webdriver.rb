require 'selenium-webdriver'
Before('@webdriver') { @driver = Selenium::WebDriver.for :firefox }
After('@webdriver') { @driver.quit }