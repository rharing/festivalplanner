package com.roja.bksscraper.dto

import com.roja.bksscraper.domain.BKSEvent
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

class EventDTO {
    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm")

    private String podium
    private Date start
    private String startWhen
    private String endWhen
    private Date end
    private String wie

    EventDTO() {
    }

    EventDTO(BKSEvent event) {
        this.start = event.start.toDate()
        this.startWhen=formatter.print(event.start)
        this.endWhen=formatter.print(event.end)
        this.end = event.end.toDate()
        this.wie = event.wie
    }
}
