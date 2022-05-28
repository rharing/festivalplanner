package com.roja.bksscraper

import spock.lang.Specification

class PodiumNameTest extends Specification {

    def "should locate correct podiumname"(){
        expect:
        _name == PodiumName.isLike(_input).name()

        where:
        _name |_input
        "ONE"| "ONE"
        "TWO"| "TWO"
        "SECRET"|"THE SECRET\r CONNECTED BY GROLSCH"

    }
}
