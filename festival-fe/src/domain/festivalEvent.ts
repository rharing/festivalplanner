export class FestivalEvent{
    start:Date;
    end: Date;
    wie: string;
    startWhen: string;
    endWhen: string;
    constructor(data){
        this.start = new Date(data.start);
        this.end = new Date(data.end);
        this.startWhen = data.startWhen
        this.endWhen = data.endWhen
        this.wie = data.wie
   }
}
