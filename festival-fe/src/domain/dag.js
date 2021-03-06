import {podium} from './podium';
export function dag(data) {
    this.dag = new Date(data.dag)
    this.when = data.when
    this.podiums = [];
    for (const element of data.podiums) {
        const mypodium = element;
        let podium1 = new podium(mypodium);
        this.podiums.push(podium1)
    }

    this.allEvents = function() {
        let events = [];
        for(const element of this.podiums) {
           events =  events.concat(element.allEvents());
        }
        return events.sort((a, b) => a.start - b.start)
    }
}
