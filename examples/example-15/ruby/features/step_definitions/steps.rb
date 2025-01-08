Given('the following users are created:') do |table|
    table.hashes[0].each_value { |v| puts v }
end