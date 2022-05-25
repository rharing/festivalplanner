package com.roja.bksscraper.domain

import com.roja.bksscraper.dto.BKSSheet
import com.roja.bksscraper.dto.EventDTO
import spock.lang.Specification

/**
 * Created on 5/25/22.
 */
class BKSDagTest extends Specification {
    def "should sort the events correctly"(){
        given:
        def sheets = []
        def events = []
        EventDTO eventDTO = new EventDTO(text: "ONE")
        events.add(eventDTO)
        events.add(new EventDTO(text:  "18:15 - 19:15\rMAVIS\rSTAPLES"))
        events.add(new EventDTO(text:  "20:15 - 21:15\rLEON\rBRIDGES"))
        def data =[]
        data.add(events)
        sheets.add(new BKSSheet(sheetIndex: 0, data:data))
        when:
        BKSDag bksDag =new BKSDag(0,sheets)
        then:
        bksDag.podiums.size() == 1
        bksDag.podiums[0].events.size()==2
        bksDag.podiums[0].event[0].start.toString()==""

    }

}
