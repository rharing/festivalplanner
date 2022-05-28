package com.roja.bksscraper.dto


import org.joda.time.DateTime
import spock.lang.Specification
import spock.lang.Unroll

class EventInputFromPDFDTOTest extends Specification {
    @Unroll
    def shouldParseText(){
        given:
         EventInputFromPDFDTO eventDTO = new EventInputFromPDFDTO()
        DateTime dateTime = new DateTime(2022, 6,10,0,0,0)
        expect:
        eventDTO.setText(_tekst)
        def parse = eventDTO.parse(dateTime)
        _parseFoundEvent == parse.isPresent()
        if (parse.isPresent()){
            def bKSEvent = parse.get()
            if(bKSEvent.podium){
                _podiumName =bKSEvent.podium.name.toString()
            }

        }

        where:
        _tekst| _parseFoundEvent |_podiumName
        ""  | false| ""
        "HOSTED BY"  | false|""
        "ONE"| true|"ONE"
        "\"18:15 - 19:15\\rMAVIS\\rSTAPLES\"" | true |""
    }

    def "should see event data"(){
        given:
        EventInputFromPDFDTO eventDTO = new EventInputFromPDFDTO()
        DateTime dateTime = new DateTime(2022, 6,10,0,0,0)
        eventDTO.setText("18:15 - 19:15\rMAVIS\rSTAPLES")
        when:
        def optional = eventDTO.parse(dateTime)
        def bKSEvent = optional.get()
        then:
        optional.isPresent()
        bKSEvent.start == new DateTime(2022, 6,10,18,15,0)
        bKSEvent.end == new DateTime(2022, 6,10,19,15,0)
        bKSEvent.wie == "\rMAVIS\rSTAPLES"

    }

}
