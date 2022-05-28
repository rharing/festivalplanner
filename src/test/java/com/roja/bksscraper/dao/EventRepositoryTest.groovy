package com.roja.bksscraper.dao


import org.joda.time.DateTime
import spock.lang.Specification

class EventRepositoryTest extends Specification {

    def "should find day events"(){
        given:
        EventRepository eventRepository = new EventRepository()
        when:
        def festivalDag = eventRepository.loadDag(new DateTime(2022, 06, 12, 0, 0, 0))
        then:
        festivalDag.podiums.size()==4
        festivalDag.podiums[0].events.size()==4
        festivalDag.podiums[0].events[0].wie=="NovaStar"
    }
}
