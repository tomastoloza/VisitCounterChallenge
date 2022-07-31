package org.example;

import java.util.Optional;

public class UserStats {

    private final Optional<Long> visitCount;

    public UserStats(Long visitCount) {
        this.visitCount = Optional.of(visitCount);
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}
