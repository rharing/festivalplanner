import {dag} from './dag';

import {podiums} from './podiums';

export function festival(data) {
    this.view = {
        dagen: [
            {id: -2, name: 'Alles', wanted: true},
            {id: 0, name: 'Vrijdag', wanted: true},
            {id: 1, name: 'Zaterdag', wanted: true},
            {id: 2, name: 'Zondag', wanted: true},
            {id: 4, name: 'Favs', wanted: false},
        ],
        podiums: podiums,
        toggleDag(id){
            let find = this.dagen.find(dag => dag.id == id);
            find.wanted = !find.wanted
            if(id ==-2){
                //set all dagen to the alles state
                this.dagen.forEach(dag => dag.wanted = find.wanted)
            }
        }
    }
    this.dagen = [];
    for (const mydag of data) {
        this.dagen.push(new dag(mydag))
    }

    this.allEvents = function () {
        let events = [];
        for (const element of this.dagen) {
            const mydag = element;
            events = events.concat(mydag.allEvents());
        }
        return events
    }
    this.filterEvents = function(){
        let events = [];
        let alledagen = this.view.dagen[1].wanted && this.view.dagen[2].wanted && this.view.dagen[3].wanted
        if(!alledagen) {
            for (let i = 1; i < this.view.dagen.length-1; i++) {
                let dag = this.view.dagen[i];
                if(dag.wanted) {
                    events = events.concat(this.dagen[dag.id].allEvents());
                }
            }
        }else {
            events = allEvents();
        }
        return events.sort((a, b) => a.start - b.start)
    }
}
