import counters.Counter;
import counters.CounterFactory;
import helpers.FileHelper;

import java.util.List;
import java.util.Map;

public class PatternCounter {

    public static void main(String[] args) {
        List<String> fileContents = FileHelper.readInputFile(args[0]);
        Counter selectedCounter = CounterFactory.getCounterType(Integer.valueOf(args[1]));
        Map<String, Long> output = selectedCounter.count(fileContents);

        output.forEach((k, v) -> System.out.println(k + ", " + v));
    }
}
