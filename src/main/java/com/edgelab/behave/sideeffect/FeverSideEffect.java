package com.edgelab.behave.sideeffect;

import com.edgelab.domain.Effect;
import com.edgelab.domain.Patient;
import com.edgelab.domain.StatusEnum;

import java.util.Optional;

public class FeverSideEffect implements Effect {


    private static final FeverSideEffect INSTANCE = new FeverSideEffect();

    private FeverSideEffect() {
    }

    public static FeverSideEffect getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<StatusEnum> newStatus(final Patient patient) {
        return Optional.of(StatusEnum.F);
    }
}
