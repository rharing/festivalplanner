package com.roja.bksscraper.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.roja.bksscraper.PodiumName
import com.roja.bksscraper.domain.BKSEvent
import com.roja.bksscraper.domain.Podium
import org.joda.time.DateTime

import java.util.regex.Matcher
import java.util.regex.Pattern

class EventDTO {

    private Pattern eventPattern = Pattern.compile("(\\d\\d:\\d\\d) - (\\d\\d:\\d\\d)((.*))")
    @JsonProperty("top")
    private String top
    @JsonProperty("left")
    private String left
    @JsonProperty("width")
    private String width
    @JsonProperty("height")
    private String height
    @JsonProperty("text")
    String text

    Optional<BKSEvent> parse(DateTime datum) {
        Optional<BKSEvent> result = Optional.empty()
        if (text.equals("") || text.startsWith("HOSTED BY")) {
            return result
        }
        try {
            def podiumName = PodiumName.valueOf(text)
            def event = new BKSEvent()
            event.podium = new Podium(name: podiumName)
            return Optional.of(event)
        } catch (IllegalArgumentException e) {
            result = parseEvent(datum)
        }
        result
    }

    Optional<BKSEvent> parseEvent(DateTime datum) {
        Optional<BKSEvent> result = Optional.empty()
        def matcher = eventPattern.matcher(text)
        if (matcher.find()) {
            def startTime = matcher.group(1)
            def start = createTime(datum, startTime)
            def endTime = matcher.group(2)
            def end = createTime(datum, endTime)
            def who = text.split(endTime)[1]
            if (start.isPresent() && end.isPresent()) {
                BKSEvent bksEvent = new BKSEvent(wie: who, start: start.get(), end: end.get())
                result = Optional.of(bksEvent)
            }
        }
        result
    }

    Optional<DateTime> createTime(DateTime datum, String dateTime) {
        def timeFields = dateTime.split(":")
        Optional<DateTime> result = Optional.empty()
        if (timeFields.length == 2) {
            DateTime when = new DateTime(datum).withTimeAtStartOfDay()
            when = when.plusHours(Integer.parseInt(timeFields[0]))
            when = when.plusMinutes(Integer.parseInt(timeFields[1]))
            result = Optional.of(when)
        }
        result
    }
}
