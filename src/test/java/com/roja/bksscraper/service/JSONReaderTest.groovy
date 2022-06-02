package com.roja.bksscraper.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.roja.bksscraper.dto.FestivalDagDTO
import org.spockframework.util.IoUtil
import org.springframework.core.io.ClassPathResource;
import spock.lang.Specification

class JSONReaderTest extends Specification {

    def "should parse the json"() {
        when:
        JSONReader jsonReader = new JSONReader("bks.json")
        then:
        jsonReader != null
        jsonReader.festival != null
        jsonReader.festival.days.size() == 3
        jsonReader.festival.days.get(0).podiums.size() == 8

        when:
        def dagen = []
        jsonReader.festival.days.each { dagen.add(new FestivalDagDTO(it)) }
        ObjectMapper objectMapper = new ObjectMapper()
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        def content = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString (dagen).replaceAll("\\s+","")
        ClassPathResource classPathResource = new ClassPathResource("bks_parsed.json")
        def expected = IoUtil.getText(classPathResource.inputStream).replaceAll("\\s+","")
        then:
        content == expected
    }
}