package com.roja.bksscraper.domain

import com.roja.bksscraper.dto.BKSSheet
import com.roja.bksscraper.dto.EventDTO
import org.joda.time.DateMidnight
import org.joda.time.DateTime

class BKSDag {

    private DateTime datum
    private List<Podium> podiums

    BKSDag(Integer dagIndex, List<BKSSheet> sheets) {
        Podium currentPodium;
        datum = new DateMidnight(2022, 6,10).plusDays(dagIndex)
        for (int i = 0; i < sheets.size(); i++) {
            BKSSheet bksSheet =  sheets.get(i);
            for(EventDTO eventDto :bksSheet.data.flatten()){
                eventDto.parse(datum)
            }

        }
    }
}
