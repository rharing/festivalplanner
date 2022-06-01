package com.roja.ziggo

import groovy.json.JsonSlurper
import groovy.util.slurpersupport.GPathResult

class FruitReader {
    def read(String filename, String when) {
        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parse(new File(filename))
        String content = object.fruitOrder.orderBase64
        def xml = new String(Base64.decoder.decode(content))
        println xml
        def rootNode = new XmlSlurper().parseText(xml)
        def colors = rootNode.FruitColors.FruitColor.collectEntries {
            [it.@id.text(), it.@desc.text()]
        }
        print colors
        def types = rootNode.FruitTypes.FruitType.collectEntries {
            [it.@id.text(), it.@desc.text()]
        }
        print types
        def result = rootNode.FruitRecords.FruitRecord.'**'.findAll {
            it.name() == "FruitExpiryDate" && it.text().startsWith(when)
        }.each { fruitRecord ->
            return fruitRecord.
        }


        print result
    }

}
public Class Fruit {
    String type,
    String color,
    Integer aantal
}
