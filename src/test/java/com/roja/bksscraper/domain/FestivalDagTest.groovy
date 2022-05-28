package com.roja.bksscraper.domain

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.roja.bksscraper.dto.BKSSheet
import com.roja.bksscraper.dto.EventInputFromPDFDTO
import org.joda.time.DateTime
import spock.lang.Specification

/**
 * Created on 5/25/22.
 */
class FestivalDagTest extends Specification {
    def "should sort the events correctly"(){
        given:
        def sheets = []
        def events = []
        EventInputFromPDFDTO eventDTO = new EventInputFromPDFDTO(text: "ONE")
        events.add(eventDTO)
        events.add(new EventInputFromPDFDTO(text:  "18:15 - 19:15\rMAVIS\rSTAPLES"))
        events.add(new EventInputFromPDFDTO(text:  "20:15 - 21:15\rLEON\rBRIDGES"))
        def data =[]
        data.add(events)
        sheets.add(new BKSSheet(sheetIndex: 0, data:data))
        when:
        FestivalDag bksDag =new FestivalDag(0,sheets)
        then:
        bksDag.podiums.size() == 1
        bksDag.podiums[0].events.size()==2
        bksDag.podiums[0].events[0].start.toString()=="2022-06-10T18:15:00.000+02:00"
        bksDag.podiums[0].events[0].end.toString()=="2022-06-10T19:15:00.000+02:00"
        bksDag.podiums[0].events[0].wie=="\rMAVIS\rSTAPLES";
        bksDag.podiums[0].events[1].start.toString()=="2022-06-10T20:15:00.000+02:00"
        bksDag.podiums[0].events[1].end.toString()=="2022-06-10T21:15:00.000+02:00"

    }
    def " build sunday by hand"(){
        def datum = new DateTime(2022, 6, 12, 0, 0, 0)

        FestivalDag bksDag = new FestivalDag(datum:datum)
//        bksDag.datum=datum

        BKSEvent bKSEvent = new EventInputFromPDFDTO().parseEvent(datum,"ONE/15:00 - 16:00 NovaStar").get()
        Podium podium = bKSEvent.podium
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"ONE/17:00 - 18:00 Wolf Alice").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"ONE/19:00 - 20:15 King Gizzard & the lizard wizzard").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"ONE/21:00 - 23:00 Nick Cave &the bad seeds").get())
        bksDag.podiums.add(podium)
        bKSEvent = new EventInputFromPDFDTO().parseEvent(datum,"TWO/12:00 - 13:30 Amenra").get()
        podium = bKSEvent.podium
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"TWO/14:00 - 15:00 Black Midi").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"TWO/16:00 - 17:00 Sampa The Great").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"TWO/18:00 - 19:00 Sky Fereira").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"TWO/20:15 - 21:15 Mura Musa").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"TWO/22:30 - 00:45 2ManyDjs").get())
        bksDag.podiums.add(podium)
        bKSEvent = new EventInputFromPDFDTO().parseEvent(datum,"SECRET/13:00 - 13:45 Meskerem Mees").get()
        podium = bKSEvent.podium
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"SECRET/14:30 - 15:15 Spelling").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"SECRET/16:00 - 16:45 Casandra Jenkins").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"SECRET/17:30 - 18:15 Nilufer YanYa").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"SECRET/19:00 - 19:45 Holly Humberstone").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"SECRET/20:30 - 21:30 Jehny Beth").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"SECRET/22:15 - 23:15 Automatic").get())
        bksDag.podiums.add(podium)
        bKSEvent = new EventInputFromPDFDTO().parseEvent(datum,"CASBAH/15:15 - 16:00 Luz").get()
        podium = bKSEvent.podium
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum,"CASBAH/16:45 - 17:30 Nagasaki Swim").get())
        when:
        ObjectMapper objectMapper = new JsonMapper()
        objectMapper.registerModule(new JodaModule());
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

        then:
        objectMapper.writeValueAsString(bksDag)== ""
    }
    def "parse full"(){
        when:
        def datum = new DateTime(2022, 6, 12, 0, 0, 0)
        BKSEvent bKSEvent = new EventInputFromPDFDTO().parseEvent(datum,  "ONE/15:00 - 16:00 NovaStar").get()
        then:
        bKSEvent.podium != null
        bKSEvent.wie == "NovaStar"
    }
}
