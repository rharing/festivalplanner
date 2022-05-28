package com.roja.bksscraper.dto

import com.roja.bksscraper.domain.BKSEvent
import com.roja.bksscraper.domain.Podium

class PodiumDTO {
    private String name;
    private List<EventDTO> events = []

    PodiumDTO() {
    }

    PodiumDTO(Podium podium) {
        this.name = podium.name.name()
        podium.events.each {
            events.add(new EventDTO(it))

        }
    }
}
