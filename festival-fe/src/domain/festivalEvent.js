export function FestivalEvent(data, podium){
        this.podium = podium;
        this.start = new Date(data.start);
        this.end = new Date(data.end);
        this.startWhen = data.startWhen
        this.endWhen = data.endWhen
        this.wie = data.wie
    this.fav = false;
}
