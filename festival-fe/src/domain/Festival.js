import {dag} from './dag';

export function festival(data) {
    this.nou = "moe"
    this.dagen = [];
    for (const mydag of data) {
        this.dagen.push(new dag(mydag))
    }

    this.allEvents = function() {
        let events = [];
        for (const element of this.dagen) {
            const mydag = element;
            events.concat(mydag.allEvents());
        }
        return events
    }
}