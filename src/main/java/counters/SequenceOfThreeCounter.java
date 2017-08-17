package counters;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SequenceOfThreeCounter implements Counter {
    @Override
    public Map<String, Long> count(List<String> content) {
        List<List<String>> lists = content.stream()
                .map(line -> Arrays.asList(line.split(" ")))
                .filter(array -> array.size() > 2)
                .collect(Collectors.toList());
        List<List<String>> sublists = new ArrayList<>();
        for(List<String> list : lists) {
            for (int i = 0; i < list.size()-2; i++) {
                sublists.add(list.subList(i,i+3));
            }
        }
        Map<List<String>, Long> map = sublists.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> result = new HashMap<>();
        for (List<String> sequence : map.keySet()) {
            String seqString = sequence.stream().collect(Collectors.joining(" "));
            result.put(seqString, map.get(sequence));
        }
        return result;
    }
}
