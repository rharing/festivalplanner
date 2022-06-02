import {FestivalEvent} from './festivalEvent'
export function podium(data) {
    this.name = data.name;
    this.events =[];
    for (let i = 0; i < data.events.length; i++) {
        const myevent = data.events[i];
        let festivalEvent1 = new FestivalEvent(myevent, this.name);
        this.events.push(festivalEvent1);
    }

    function allEvents(){
        return this.events;
    }
}
