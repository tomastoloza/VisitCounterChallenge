package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        VisitCounter visitCounter = new VisitCounter();
        visitCounter.count();


        Map<String, UserStats> visits = new HashMap<>();
        visits.put("1234123L", new UserStats(1000L));
        visits.put(null, new UserStats(1000L));
        visits.put("123", null);
        visits.put("123", new UserStats(1000L));
        visits.put("123123123123", new UserStats(1000L));
        visits.put("123123123123", new UserStats(2000L));

//        visitCounter.count(visits);
        visitCounter.count(visits, visits);


    }
}
