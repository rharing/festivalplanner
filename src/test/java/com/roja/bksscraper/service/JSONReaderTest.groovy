package com.roja.bksscraper.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.roja.bksscraper.dto.BKSSheet
import org.springframework.core.io.ClassPathResource
import spock.lang.Specification

class JSONReaderTest extends Specification {

    def "should parse the json"(){
        when:
        JSONReader jsonReader = new JSONReader("bks.json")
        then:
        jsonReader != null

    }
}
