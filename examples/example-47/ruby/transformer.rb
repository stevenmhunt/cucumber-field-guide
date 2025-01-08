$param_transform_callbacks = []
$dt_cell_transform_callbacks = []

module CustomWorld
    attr_accessor :item, :user1
end
World(context: CustomWorld)

def parameter_transformer(&callback)
    $param_transform_callbacks.append(callback)
end

def data_table_cell_transformer(&callback)
    $dt_cell_transform_callbacks.append(callback)
end

def transformer(&stepdef)
    process_val = proc do |val, callbacks|
        if val.is_a?(Cucumber::MultilineArgument::DataTable)
            tbl = Cucumber::Core::Test::DataTable.new(val.hashes.map do |row|
                row.transform_values do |v|
                    instance_exec(v, $dt_cell_transform_callbacks, &process_val)
                end
            end)
            Cucumber::MultilineArgument::DataTable.new(tbl)
        else
            result = val
            callbacks.each do |cb|
                result = instance_exec(result, &cb)
            end
            result
        end
    end
    proc { |*args|
        result = args.map do |arg|
            instance_exec(arg, $param_transform_callbacks, &process_val)
        end
        instance_exec(*result, &stepdef)
    }
end