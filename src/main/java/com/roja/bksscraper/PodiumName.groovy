package com.roja.bksscraper;

public enum PodiumName {
    ONE("ONE"),
    TWO("TWO"),
    SECRET("THE SECRET"),
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

    public static PodiumName isLike(String name){
        for(PodiumName podiumName: values()){
            if (name.startsWith(podiumName.fullname)){
                return podiumName;
            }
        }
        throw new IllegalArgumentException("nope");
    }
}
