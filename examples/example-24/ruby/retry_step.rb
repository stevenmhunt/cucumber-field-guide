require 'retries'

with_retries(
    max_tries: 10,
    rescue: [StandardError],
    base_sleep_seconds: 0.1,
    max_sleep_seconds: 2.0
) do
    # code which may require retries
end