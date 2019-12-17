package com.edgelab.domain;

import java.util.Optional;

public interface Effect {

    default Optional<StatusEnum> newStatus(final Patient patient) {
        return Optional.empty();
    }
}
