package org.example;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VisitCounter {

    private static Logger logger = LoggerFactory.getLogger(VisitCounter.class);

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> resultMap = new HashMap<>();
        Arrays.stream(visits).forEach(visit -> {
            // Iterates every entry
            // TODO: Investigate how to do it with streams
            for (Map.Entry<String, UserStats> entry : visit.entrySet()) {
                sumValues(entry.getValue(), entry.getKey(), resultMap);
            }
        });
        logger.error("ResultMap = " + resultMap);
        return resultMap;
    }

    public void sumValues(UserStats userStats, String key, Map<Long, Long> resultMap) {
        if (userStats != null && userStats.getVisitCount().isPresent()) {
            try {
                long resultCount = 0L;
                Long keyValue = Long.parseLong(key);
                resultCount += userStats.getVisitCount().get();
                Long previousValue = resultMap.get(keyValue);
                // checks if the key has a previous value
                if (previousValue != null) {
                    resultCount += previousValue;
                }
                resultMap.put(keyValue, resultCount);
            } catch (NumberFormatException e) {
                logger.error(String.format("Could not parse key with value %s", key));
            }
        }

    }
}
