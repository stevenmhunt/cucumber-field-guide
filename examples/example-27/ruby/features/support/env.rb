# skip all remaining tests once this number has been reached.
$FAILURE_THRESHOLD = 3

# a place to track the number of failed {{scenario}}s.
$failCount = 0

# check if the fail count has been exceeded.
Before do
    skip_this_scenario if $failCount >= $FAILURE_THRESHOLD
end

# increments fail count if the test failed.
After do |scenario|
    $failCount += 1 if scenario.failed?
end