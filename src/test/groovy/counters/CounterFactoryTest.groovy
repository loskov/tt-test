package counters

import spock.lang.Specification
import spock.lang.Unroll

class CounterFactoryTest extends Specification {
    @Unroll
    def "CounterFactory should return #clazz for mode #mode"() {
        expect:
        clazz in CounterFactory.getCounterType(mode).class
        where:
        mode || clazz
        1    || UniqueWordCounter
        2    || UniqueNumberCounter
        3    || SequenceOfThreeCounter
    }

    def "CounterFactory throws exception for unknown mode"() {
        when:
        CounterFactory.getCounterType(12)
        then:
        thrown UnsupportedOperationException
    }
}
