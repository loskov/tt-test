package counters

import helpers.FileHelper
import spock.lang.Specification

class UniqueWordCounterTest extends Specification {
    def "Word counter works as specified"() {
        given:
        Counter counter = new UniqueWordCounter()
        List content = FileHelper.readInputFile("input.txt")
        when:
        def result = counter.count(content)
        then:
        assert ["a": 2, "big": 2, "surprise": 2, "is": 1, "hello": 1] == result

    }
}
