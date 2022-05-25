package com.roja.bksscraper.domain

import com.roja.bksscraper.PodiumName
import com.roja.bksscraper.domain.BKSEvent
import org.apache.commons.collections.list.TreeList

class Podium {
    private PodiumName name
    private Set<BKSEvent> events =new TreeSet<BKSEvent>(new Comparator<BKSEvent>() {
        @Override
        int compare(BKSEvent o1, BKSEvent o2) {
            return o1.start.compareTo(o2.start)
        }
    })

    def void addEvent(BKSEvent event) {
       events.add(event)
    }
}
