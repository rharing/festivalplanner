package com.roja.ziggo

import spock.lang.Specification

class FruitReaderTest extends Specification {

    def "read the file"(){
        given:
        FruitReader fruitReader = new FruitReader()
        when:
        fruitReader.read("C:\\projects\\tryout\\festivalplanner\\src\\main\\resources\\FruitExport_20220601.json","2023-06-01")
        then:
        fruitReader != null
    }
    def test(){
        given:
        def doc = """
<html>
<head>
</head>
    <body>
        <div tags="1">test1</div>
        <div>test2</div>
        <div tags="">test3</div>
        <div tags="4">test4</div>
    </body>
</html>
"""

        when:
        def html = new XmlSlurper().parseText( doc)

        def result = html.body.div.findAll { it }.each { div ->
            return div
        }

        then:
        result.size() ==4
    }
    def "nog test"(){
        given:
        def xml = "<root>\n\t<item name=\"a\" value=\"1\"/>\n\t<item name=\"b\" value=\"2\"/>\n</root>";
        System.out.println("XML is: \n" + xml);

        when:
        def document = new XmlSlurper().parseText(xml); // Convert the XML into an Object Model

        System.out.println("\nElements are:");
        for (item in document.item)
        {
            System.out.println(item.@name.text() + "=" + item.@value.text());
        }

        System.out.println("\nJust the value of the 'value' attributes: " + document."item".@value.text());
        then:
        document.item != null
    }
}
