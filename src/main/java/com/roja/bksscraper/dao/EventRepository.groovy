package com.roja.bksscraper.dao

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import com.roja.bksscraper.domain.BKSEvent
import com.roja.bksscraper.domain.FestivalDag
import com.roja.bksscraper.dto.EventDTO
import com.roja.bksscraper.dto.FestivalDagDTO
import org.joda.time.DateTime
import org.springframework.core.io.ClassPathResource

class EventRepository {
    private List<FestivalDagDTO> dagen = []

    EventRepository() {
        ClassPathResource classPathResource = new ClassPathResource("bks_parsed.json")
        ObjectMapper objectMapper = new ObjectMapper()
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        dagen = Arrays.asList(objectMapper.readValue(classPathResource.inputStream, FestivalDagDTO[].class));
    }

    public FestivalDagDTO  listEvents(DateTime when) {
        def dag = FestivalDagDTO.formatter.print(when)

        return dagen.find {it.when == dag}
    }
}
