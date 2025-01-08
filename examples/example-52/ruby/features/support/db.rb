require_relative '../utils/db'

test_db_connect

Before do
    db_create_schema
    test_db_load_baseline
end