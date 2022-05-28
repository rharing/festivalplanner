package com.roja.bksscraper.dto

import com.fasterxml.jackson.annotation.JsonProperty

class BKSSheet {

    @JsonProperty("extraction_method")
    private String extractionMethod
    @JsonProperty("top")
    private String top
    @JsonProperty("left")
    private String left
    @JsonProperty("width")
    private String width
    @JsonProperty("height")
    private String height
    @JsonProperty("data")

    private List<List<EventInputFromPDFDTO>> data

    BKSSheet() {
    }

    @JsonProperty("spec_index")
    private int sheetIndex
}
