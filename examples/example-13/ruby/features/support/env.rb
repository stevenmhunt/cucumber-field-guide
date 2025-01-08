module CustomWorld
    def add_items
        @count ||= 0
        @count += 1
    end
end

World(CustomWorld)