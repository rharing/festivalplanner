import {dag} from './dag';
export function festival(data) {
    this.dagen = [];
    for (const element of data) {
        const mydag = element;
        this.dagen.push(new dag(mydag))
    }

    function allEvents() {
        this.events = [];
        for (const element of this.dagen) {
            const mydag = element;
            this.events.concat(mydag.allEvents());
        }
    }
}