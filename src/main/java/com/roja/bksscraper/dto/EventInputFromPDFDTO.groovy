package com.roja.bksscraper.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.roja.bksscraper.PodiumName
import com.roja.bksscraper.domain.BKSEvent
import com.roja.bksscraper.domain.Podium
import org.joda.time.DateTime

import java.util.regex.Matcher
import java.util.regex.Pattern

class EventInputFromPDFDTO {

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
            def podiumName = PodiumName.isLike(text)
            def event = new BKSEvent()
            event.podium = new Podium(name: podiumName)
            return Optional.of(event)
        } catch (IllegalArgumentException e) {
            result = parseEvent(datum, text)
        }
        result
    }

    Optional<BKSEvent> parseEvent(DateTime datum, String text) {
        if (text.contains("/")) {
            Optional<BKSEvent> result = Optional.empty()
            def podiumAndText = text.split("/")
            try {
                def podiumName = PodiumName.valueOf(podiumAndText[0])
                result = parseEvent(datum, podiumAndText[1])
                if (result.isPresent()) {
                    BKSEvent bKSEvent = result.get()
                    bKSEvent.podium = new Podium(name: podiumName)
                    bKSEvent.podium.addEvent(bKSEvent)
                    result = Optional.of(bKSEvent)
                }
            } catch (IllegalArgumentException e) {

            }
            return result
        }
        Optional<BKSEvent> result = Optional.empty()
        def matcher = eventPattern.matcher(text)
        if (matcher.find()) {
            def startTime = matcher.group(1)
            def start = createTime(datum, startTime)
            def endTime = matcher.group(2)
            def end = createTime(datum, endTime)
            def split = text.split(endTime)
            if(split.length==2) {
                def who = split[1]
                if (start.isPresent() && end.isPresent()) {
                BKSEvent bksEvent = new BKSEvent(wie: who.trim(), start: start.get(), end: end.get())
                    result = Optional.of(bksEvent)
                }
            }
        }
        result
    }

    Optional<DateTime> createTime(DateTime datum, String dateTime) {
        def timeFields = dateTime.split(":")
        Optional<DateTime> result = Optional.empty()
        if (timeFields.length == 2) {
            DateTime when = new DateTime(datum).withTimeAtStartOfDay()
            def hours = timeFields[0]
            if(Integer.parseInt(hours) <10){
                //new day
                when = when.plusDays(1)
            }

            when = when.plusHours(Integer.parseInt(hours))
            when = when.plusMinutes(Integer.parseInt(timeFields[1]))
            result = Optional.of(when)
        }
        result
    }
}
