package com.roja.bksscraper.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.joda.time.DateTime

class BKSEvent {
    private Podium podium
    private String wie
    private DateTime start
    private DateTime end

    @JsonIgnore
    public boolean isPodiumEvent(){
        return podium != null
    }
}
