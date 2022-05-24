package com.roja.bksscraper.service;

import com.fasterxml.jackson.databind.ObjectMapper
import com.roja.bksscraper.domain.BKSDag;
import com.roja.bksscraper.dto.BKSSheet
import org.springframework.core.io.ClassPathResource

public class JSONReader {
    public JSONReader(String file) {
        ClassPathResource classPathResource = new ClassPathResource(file);
        ObjectMapper objectMapper = new ObjectMapper();
        BKSSheet[] sheets = new BKSSheet[0];
        try {
            sheets = objectMapper.readValue(classPathResource.getInputStream(), BKSSheet[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        def days = sheets.groupBy { it.sheetIndex }

        days.entrySet().each { Integer dagIndex ->
            BKSDag bksDag = new BKSDag(dagIndex, days.get(dagIndex))

        }
        for (int i = 0; i < days.entrySet(); i++) {
            print(days[i])
        }

    }
}
