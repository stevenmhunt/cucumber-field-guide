require 'faker'

def generate_user_account
    name = Faker::Name.name
    city = Faker::Address.city
    state = Faker::Address.state
    phone_number = Faker::PhoneNumber.phone_number
    email_local = name.downcase.gsub(/\s+/, '.').gsub(/[^a-z0-9.]/, '')
    email_address = "#{email_local}@sink.mywebsite.com"

    {
        name: name,
        email: email_address,
        city: city,
        state: state,
        phone_number: phone_number
    }
end