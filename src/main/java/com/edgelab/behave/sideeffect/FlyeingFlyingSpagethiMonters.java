package com.edgelab.behave.sideeffect;

import com.edgelab.domain.Effect;
import com.edgelab.domain.Patient;
import com.edgelab.domain.StatusEnum;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public final class FlyeingFlyingSpagethiMonters implements Effect {

    private static final FlyeingFlyingSpagethiMonters INSTANCE = new FlyeingFlyingSpagethiMonters();

    private FlyeingFlyingSpagethiMonters() {
    }


    public static FlyeingFlyingSpagethiMonters instance() {
        return INSTANCE;
    }

    @Override
    public Optional<StatusEnum> newStatus(final Patient patient) {
        if (!patient.checkPulse()) {

            final int rand = ThreadLocalRandom.current().nextInt(1, 1000000);
            if (rand == 1) {
                System.out.println("Miracle Spagethi Monster healed the patient");
                return Optional.of(StatusEnum.H);
            }
        }
        return Optional.empty();
    }
}
