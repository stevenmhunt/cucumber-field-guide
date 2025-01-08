$hbs = Handlebars::Handlebars.new
$templates = {}

parameter_transformer do |val|
    if val.is_a?(String)
        $templates[val] ||= $hbs.compile(val)
        $templates[val].call(context)
    else
        val
    end
rescue StandardError => e
    val
end

data_table_cell_transformer do |val|
    if val.is_a?(String)
        $templates[val] ||= $hbs.compile(val)
        $templates[val].call(context)
    else
        val
    end
rescue StandardError => e
    val
end

$hbs.register_helper('config') do |context, value|
    value.to_s.split('.').reduce(Settings) do |acc, method|
        acc.send(method)
    end
end