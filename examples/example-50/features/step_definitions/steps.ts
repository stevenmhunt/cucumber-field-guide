import { binding, given } from 'cucumber-tsflow';

@binding()
export class Steps {

    @given('the user {string} logs in')
    public async givenTheUserLogsIn(user: string): Promise<void> {
        console.log(user);
    }
}