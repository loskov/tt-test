package counters;

import java.util.List;
import java.util.Map;

public interface Counter {
    public Map<String, Long> count(List<String> content);
}
