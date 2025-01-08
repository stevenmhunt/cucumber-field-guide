require 'ruby-handlebars'

$hbs = Handlebars::Handlebars.new

module CustomWorld
    attr_accessor :users
end

World(world: CustomWorld)

def transformer(&stepdef)
    proc { |*args|
        result = args.map do |arg|
            if arg.is_a?(String)
                $hbs.compile(arg).call(world)
            else
                arg
            end
        end
        instance_exec(*result, &stepdef)
    }
end

Given('the user {string} logs in', transformer do |user|
    # do something with the user.
end)