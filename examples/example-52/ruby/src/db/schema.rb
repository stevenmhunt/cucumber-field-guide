require 'active_record'

class User < ActiveRecord::Base
end

def db_create_schema
    ActiveRecord::Schema.define do
        create_table :users, force: true do |t|
            t.string :name
            t.timestamps
        end
    end
end