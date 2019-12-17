package com.edgelab.behave.sideeffect;

import com.edgelab.domain.Effect;
import com.edgelab.domain.Patient;
import com.edgelab.domain.StatusEnum;

import java.util.Optional;

public class DeathSideEffect implements Effect {


    private static DeathSideEffect INSTANCE = new DeathSideEffect();

    private DeathSideEffect() {
    }

    public static DeathSideEffect getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<StatusEnum> newStatus(final Patient patient) {
        return Optional.of(StatusEnum.X);
    }
}
