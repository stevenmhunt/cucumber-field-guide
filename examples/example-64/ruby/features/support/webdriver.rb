require 'selenium-webdriver'

Before('@webdriver') { @driver = Selenium::WebDriver.for :firefox }

After('@webdriver') { @driver.quit }

Before('@screenplay') do
    Screengem::ActorMemory.instance.clear
    @actor = Class.new do
        include Screengem::Actor
        def name
            'Actor 1'
        end
    end.new
    @actor.remember(browser: Abilities::Browser.new(@driver, 'http://localhost:9999'))
end