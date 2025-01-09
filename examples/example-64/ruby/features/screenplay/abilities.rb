module Abilities
    class Browser
        attr_reader :driver, :base_url

        def initialize(driver, base_url)
            @driver = driver
            @base_url = base_url
        end
    end
end