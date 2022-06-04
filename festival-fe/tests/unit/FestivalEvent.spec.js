import {FestivalEvent} from '@/domain/festivalEvent'

describe('setting up the domain', () => {
    it('creating event', () => {
        let input =
            {
                "start": 1654877700000,
                "startWhen": "2022-06-10 18:15",
                "endWhen": "2022-06-10 19:15",
                "end": 1654881300000,
                "wie": "MAVIS\rSTAPLES"
            };

        dinges:FestivalEvent = new FestivalEvent(input, {id:0,name:'One'});
    expect(dinges.wie).toBe("MAVIS\rSTAPLES");

    })
})
