require 'appium_lib'

Before('@mobile') do
    proj = File.expand_path('../..', __dir__)
    caps = Settings.mobile.appium.to_h.deep_symbolize_keys
    caps[:caps][:app] = File.join(proj, Settings.mobile.appium.caps.app)
    @appium = Appium::Driver.new(caps, true)
    Appium.promote_appium_methods Object
end

After('@mobile') { @appium.driver_quit }

class MyDemoApp
    def initialize(appium)
        @appium = appium
    end

    def find_element(name)
        @appium.find_element(:xpath, Settings.mobile.mydemoapp[name])
    end
end