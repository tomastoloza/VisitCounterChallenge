import io.github.tomastoloza.visitcounter.UserStats;
import io.github.tomastoloza.visitcounter.VisitCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class TestVisitCounter {

    private VisitCounter visitCounter;
    private Map<String, UserStats> visits;

    @BeforeEach
    void setUp() {
        visitCounter = new VisitCounter();
        visits = new HashMap<>();
    }

    @Test
    void whenStringIsInvalidResultIsEmpty() {
        visits.put("1234123L", new UserStats(1000L));
        Map<Long, Long> resultMap = visitCounter.count(visits);
        Assertions.assertTrue(resultMap.isEmpty());
    }

    @Test
    void whenKeyIsNullResultIsEmpty() {
        visits.put(null, new UserStats(1000L));
        Map<Long, Long> resultMap = visitCounter.count(visits);
        Assertions.assertTrue(resultMap.isEmpty());
    }

    @Test
    void whenValueIsNullResultIsEmpty() {
        visits.put("1111", null);
        Map<Long, Long> resultMap = visitCounter.count(visits);
        Assertions.assertTrue(resultMap.isEmpty());
    }

    @Test
    void whenKeyAndValueAreNullResultIsEmpty() {
        visits.put(null, null);
        Map<Long, Long> resultMap = visitCounter.count(visits);
        Assertions.assertTrue(resultMap.isEmpty());
    }

    @Test
    void whenUsingOneEntryResultMapIsOK() {
        visits.put("123", new UserStats(1000L));
        Map<Long, Long> resultMap = visitCounter.count(visits);
        Assertions.assertFalse(resultMap.isEmpty());
        Assertions.assertEquals(1, resultMap.size());
        Assertions.assertEquals(1000L, resultMap.get(123L));
    }

    @Test
    void whenUsingTwoEntryResultMapIsOK() {
        visits.put("123", new UserStats(1000L));
        visits.put("321", new UserStats(3000L));
        Map<Long, Long> resultMap = visitCounter.count(visits);
        Assertions.assertFalse(resultMap.isEmpty());
        Assertions.assertEquals(2, resultMap.size());
        Assertions.assertEquals(1000L, resultMap.get(123L));
        Assertions.assertEquals(3000L, resultMap.get(321L));
    }

    @Test
    void whenUsingMultipleParametersIsOK() {
        Map<String, UserStats> anotherVisits = new HashMap<>();
        visits.put("123", new UserStats(1000L));
        anotherVisits.put("123", new UserStats(1000L));
        Map<Long, Long> resultMap = visitCounter.count(visits, anotherVisits);
        Assertions.assertFalse(resultMap.isEmpty());
        Assertions.assertEquals(1, resultMap.size());
        Assertions.assertEquals(2000L, resultMap.get(123L));
    }


}
