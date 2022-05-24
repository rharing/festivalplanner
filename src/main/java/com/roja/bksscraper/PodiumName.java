package com.roja.bksscraper;

public enum PodiumName {
    ONE("ONE"),
    TWO("TWO"),
    SECRET("THE SECRET CONNECTED BY GROLSCH"),
    CASBAH("THE CASBAH"),
    FLOOR("THE FLOOR"),
    CONEY("CONEY ISLAND"),
    LAKE("LAKE DISTRICT"),
    LODGE("THE LODGE")
    ;

    private String fullname;

    PodiumName(String fullname) {
        this.fullname = fullname;
    }
}
