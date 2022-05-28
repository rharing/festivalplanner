package com.roja.bksscraper.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.roja.bksscraper.dto.BKSSheet
import com.roja.bksscraper.dto.EventInputFromPDFDTO
import org.joda.time.DateTime

class FestivalDag {

    private DateTime datum
    private List<Podium> podiums = []

    FestivalDag() {
    }

    FestivalDag(Integer dagIndex, List<BKSSheet> sheets) {
        Podium currentPodium
        datum = new DateTime(2022, 6, 10, 0, 0, 0).plusDays(dagIndex)
        for (int i = 0; i < sheets.size(); i++) {
            BKSSheet bksSheet = sheets.get(i)
            for (EventInputFromPDFDTO eventDto : bksSheet.data.flatten()) {
                Optional<BKSEvent> optional = eventDto.parse(datum)
                if (optional.isPresent()) {
                    BKSEvent bksEvent = optional.get()
                    if (bksEvent.isPodiumEvent()) {
                        if (currentPodium != null) {
                            podiums.add(currentPodium)
                        }
                        currentPodium = new Podium(name: bksEvent.podium.name)

                    } else {
                        currentPodium.addEvent(bksEvent)
                    }
                }
            }

        }
        if (currentPodium != null){
            podiums.add(currentPodium)
        }

        if (currentPodium != null){
            podiums.add(currentPodium)
        }
    }
}
