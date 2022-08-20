export function FestivalEvent(data, podium){
        this.podium = podium.name;
        this.start = new Date(data.start);
        this.end = new Date(data.end);
        this.artist = data.artist
    this.fav = false;
}
