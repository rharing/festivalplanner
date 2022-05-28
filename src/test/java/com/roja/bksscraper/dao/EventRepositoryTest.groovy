package com.roja.bksscraper.dao

import com.roja.bksscraper.dto.EventDTO
import org.joda.time.DateTime
import spock.lang.Specification

class EventRepositoryTest extends Specification {

    def "should find day events"(){
        given:
        EventRepository eventRepository = new EventRepository()
        when:
        def festivalDag = eventRepository.listEvents(new DateTime(2022, 06, 12, 0, 0, 0))
        then:
        festivalDag.podiums.size()==4
        festivalDag.podiums[0].events.size()==4
        festivalDag.podiums[0].events[0].wie=="NovaStar"
    }
}
