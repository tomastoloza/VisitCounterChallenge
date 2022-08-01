package io.github.tomastoloza.visitcounter;

import java.util.Optional;

public class UserStats {

    private final Optional<Long> visitCount;

    // Using constructor for simplicity
    public UserStats(Long visitCount) {
        this.visitCount = Optional.of(visitCount);
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}
