# a place to track the number of failed {{scenario}}s.
$failedFilters = {}
$FAILURE_THRESHOLD = 1

def get_tag_filter(scenario)
    scenario.source_tag_names.filter { |tag| tag.index('@feature_').zero? }.first
end

# check if the fail count has been exceeded.
Before do |scenario|
    filter = get_tag_filter(scenario)
    skip_this_scenario if $failedFilters.key?(filter) &&
                          $failedFilters[filter] >= $FAILURE_THRESHOLD
end

# increments fail count if the test failed.
After do |scenario|
    if scenario.failed?
        filter = get_tag_filter(scenario)
        $failedFilters[filter] = ($failedFilters[filter] || 0) + 1
    end
end