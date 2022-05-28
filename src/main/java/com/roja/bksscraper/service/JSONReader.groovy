package com.roja.bksscraper.service

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper
import com.roja.bksscraper.domain.FestivalDag
import com.roja.bksscraper.domain.BKSEvent
import com.roja.bksscraper.domain.Festival
import com.roja.bksscraper.domain.Podium;
import com.roja.bksscraper.dto.BKSSheet
import com.roja.bksscraper.dto.EventInputFromPDFDTO
import com.roja.bksscraper.dto.FestivalDagDTO
import org.joda.time.DateTime
import org.springframework.core.io.ClassPathResource

public class JSONReader {
    Festival festival = new Festival()

    public JSONReader(String file) {
        festival = new Festival(name: "bks")
        ClassPathResource classPathResource = new ClassPathResource(file);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        BKSSheet[] sheets = new BKSSheet[0];
        try {
            sheets = objectMapper.readValue(classPathResource.getInputStream(), BKSSheet[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        def days = sheets.groupBy { it.sheetIndex }

        festival.name = "BKS"
        FestivalDag bksDag = new FestivalDag(0, days.get(0))
        festival.days.add(bksDag)
        bksDag = new FestivalDag(1, days.get(1))
        festival.days.add(bksDag)
        // dag 3 wil niet goed ge-extract worden dus doe ik die maar handmatig
        festival.days.add(buildSunday())

        def dagen = []
        festival.days.each { dagen.add(new FestivalDagDTO(it)) }
    }

    FestivalDag buildSunday() {
        def datum = new DateTime(2022, 6, 12, 0, 0, 0)

        FestivalDag bksDag = new FestivalDag(datum: datum)

        BKSEvent bKSEvent = new EventInputFromPDFDTO().parseEvent(datum, "ONE/15:00 - 16:00 NovaStar").get()
        Podium podium = bKSEvent.podium
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "ONE/17:00 - 18:00 Wolf Alice").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "ONE/19:00 - 20:15 King Gizzard & the lizard wizzard").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "ONE/21:00 - 23:00 Nick Cave &the bad seeds").get())
        bksDag.podiums.add(podium)
        bKSEvent = new EventInputFromPDFDTO().parseEvent(datum, "TWO/12:00 - 13:30 Amenra").get()
        podium = bKSEvent.podium
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "TWO/14:00 - 15:00 Black Midi").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "TWO/16:00 - 17:00 Sampa The Great").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "TWO/18:00 - 19:00 Sky Fereira").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "TWO/20:15 - 21:15 Mura Musa").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "TWO/22:30 - 00:45 2ManyDjs").get())
        bksDag.podiums.add(podium)
        bKSEvent = new EventInputFromPDFDTO().parseEvent(datum, "SECRET/13:00 - 13:45 Meskerem Mees").get()
        podium = bKSEvent.podium
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "SECRET/14:30 - 15:15 Spelling").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "SECRET/16:00 - 16:45 Casandra Jenkins").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "SECRET/17:30 - 18:15 Nilufer YanYa").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "SECRET/19:00 - 19:45 Holly Humberstone").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "SECRET/20:30 - 21:30 Jehny Beth").get())
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "SECRET/22:15 - 23:15 Automatic").get())
        bksDag.podiums.add(podium)
        bKSEvent = new EventInputFromPDFDTO().parseEvent(datum, "CASBAH/15:15 - 16:00 Luz").get()
        podium = bKSEvent.podium
        podium.addEvent(new EventInputFromPDFDTO().parseEvent(datum, "CASBAH/16:45 - 17:30 Nagasaki Swim").get())
        bksDag.podiums.add(podium)
        bksDag
    }
}
