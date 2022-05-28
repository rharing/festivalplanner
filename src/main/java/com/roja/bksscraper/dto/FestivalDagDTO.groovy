package com.roja.bksscraper.dto;

import com.roja.bksscraper.domain.FestivalDag
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

public class FestivalDagDTO {
    public static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
    private Date dag
    private String when
    private List<PodiumDTO> podiums =[]

    FestivalDagDTO() {
    }

    FestivalDagDTO(FestivalDag dag) {
        this.dag = dag.datum.toDate()
this.when = formatter.print(dag.datum)
        dag.podiums.each {
            podiums.add(new PodiumDTO(it))
        }
    }
}
