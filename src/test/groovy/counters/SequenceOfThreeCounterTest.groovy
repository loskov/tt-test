package counters

import helpers.FileHelper
import org.junit.Ignore
import spock.lang.Specification

class SequenceOfThreeCounterTest extends Specification {
    @Ignore
    def "Sequence counter works as specified"() {
        given:
        Counter counter = new SequenceOfThreeCounter()
        List content = FileHelper.readInputFile("input.txt")
        when:
        def result = counter.count(content)
        then:
        assert ["1000 a big": 1,
                "a big surprise":2,
                "big surprise 2000":1,
                "surprise 2000 hello":1,
                "2000 hello is":1,
                "hello is a":1,
                "is a big":1,
                "big surprise 1000":1] == result
    }
}
