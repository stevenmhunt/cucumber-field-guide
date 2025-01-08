def transformer(&stepdef)
    proc { |*args|
        # do something with the args...
        instance_exec(*args, &stepdef)
    }
end

Given('the user adds {int} items', transformer do |i|
    # transformed args will be passed here.
end)