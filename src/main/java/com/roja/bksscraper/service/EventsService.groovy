package com.roja.bksscraper.service

import com.roja.bksscraper.dao.EventRepository
import com.roja.bksscraper.dto.EventDTO
import org.joda.time.DateTime

class EventsService {
    private EventRepository eventRepository

    public List<EventDTO> listEvents(DateTime when){
        eventRepository.loadDag(when)

    }
}
