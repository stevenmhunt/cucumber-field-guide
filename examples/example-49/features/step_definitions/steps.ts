import { Given } from '@cucumber/cucumber';

Given('the user {string} logs in', async function(user: string): Promise<void> {
    console.log(user);
});