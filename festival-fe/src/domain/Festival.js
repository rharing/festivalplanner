import {dag} from './dag';

export function festival(data) {
    this.dagen = [];
    for (const mydag of data) {
        this.dagen.push(new dag(mydag))
    }

    this.allEvents = function () {
        let events = [];
        for (const element of this.dagen) {
            const mydag = element;
            events = events.concat(mydag.allEvents());
            console.log("events", events)
        }
        return events
    }
}