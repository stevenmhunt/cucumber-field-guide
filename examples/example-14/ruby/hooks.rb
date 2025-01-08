Before do |scenario|
    # run code before each scenario.
end

After do |scenario|
    # run code after each scenario.
end

Around do |scenario, block|
    # run code before each scenario.
    block.call
    # run code after each scenario.
end

# run code before all scenarios.
at_exit do
    # run code after all scenarios.
end

# Note: there is no BeforeStep hook.

AfterStep do |scenario|
    # run code after each step of a scenario.
end

# conditional hooks:
Before('@smoke and @ui') do |scenario|
    # run code before each scenario.
end

After('@smoke and @ui') do |scenario|
    # run code after each scenario.
end