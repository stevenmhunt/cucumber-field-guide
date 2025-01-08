const { faker } = require('@faker-js/faker');

function generateUserAccount() {
    const name = faker.name.findName();
    const city = faker.address.city();
    const state = faker.address.state();
    const phoneNumber = faker.phone.phoneNumber();

    const emailLocalPart = name.toLowerCase()
        .replace(/\s+/g, '.')
        .replace(/[^a-z0-9.]/g, '');
    const email = `${emailLocalPart}@sink.mywebsite.com`;

    return { name, email, city, state, phoneNumber };
}

module.exports = { generateUserAccount };