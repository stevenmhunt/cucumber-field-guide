require 'timeout'

# apply the timeout for each scenario:
Around do |scenario, block|
    Timeout.timeout(30) do
        block.call
    end
end

# apply the timeout to a specific step:
Given 'some step that needs a timeout' do
    Timeout.timeout(30) do
        # your step definition code...
    end
end