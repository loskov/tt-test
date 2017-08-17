package counters;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueWordCounter implements Counter{
    @Override
    public Map<String, Long> count(List<String> content) {
        return content.stream()
                .map(line -> Arrays.asList(line.split(" ")))
                .flatMap(Collection::stream)
                .filter(text -> text.matches("[a-z]*"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
