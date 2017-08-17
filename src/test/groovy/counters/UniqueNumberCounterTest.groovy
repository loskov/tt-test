package counters

import helpers.FileHelper
import spock.lang.Specification

class UniqueNumberCounterTest extends Specification {
    def "Number counter works as specified"() {
        given:
        Counter counter = new UniqueNumberCounter()
        List content = FileHelper.readInputFile("input.txt")
        when:
        def result = counter.count(content)
        then:
        assert ["1000": 2, "2000":1] == result

    }
}
