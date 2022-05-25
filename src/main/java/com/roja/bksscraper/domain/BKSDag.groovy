package com.roja.bksscraper.domain

import com.roja.bksscraper.dto.BKSSheet
import com.roja.bksscraper.dto.EventDTO
import org.joda.time.DateTime

class BKSDag {

    private DateTime datum
    private List<Podium> podiums = []

    BKSDag(Integer dagIndex, List<BKSSheet> sheets) {
        Podium currentPodium
        datum = new DateTime(2022, 6, 10, 0, 0, 0).plusDays(dagIndex)
        for (int i = 0; i < sheets.size(); i++) {
            BKSSheet bksSheet = sheets.get(i)
            for (EventDTO eventDto : bksSheet.data.flatten()) {
                Optional<BKSEvent> optional = eventDto.parse(datum)
                if (optional.isPresent()) {
                    BKSEvent bksEvent = optional.get()
                    if (bksEvent.isPodiumEvent()) {
                        if (currentPodium == null) {
                            currentPodium = new Podium(name: bksEvent.podium.name)
                        } else {
                            podiums.add(currentPodium)
                        }
                    } else {
                        currentPodium.addEvent(bksEvent)
                    }
                }
            }

        }
    }
}
