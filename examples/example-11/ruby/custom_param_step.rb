ParameterType(
    name: 'isoDate',
    regexp: /\d{4}-\d{2}-\d{2}/,
    type: Date,
    transformer: ->(date) { Date.parse(date) }
)

When('the user selects the date {isoDate}') do |date|
    # do something with the date...
end