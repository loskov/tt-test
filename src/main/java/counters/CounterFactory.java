package counters;

public class CounterFactory {

    private Counter counterType;

    public static Counter getCounterType(Integer mode) {
        switch (mode) {
            case 1:
                return new UniqueWordCounter();
            case 2:
                return new UniqueNumberCounter();
            case 3:
                return new SequenceOfThreeCounter();
            default:
                throw new UnsupportedOperationException("No such Counter type");
        }
    }
}
