package com.edgelab.behave;

import com.edgelab.behave.sideeffect.FlyeingFlyingSpagethiMonters;
import com.edgelab.domain.Effect;
import com.edgelab.domain.Patient;
import com.edgelab.domain.StatusEnum;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class PatientHandler {

    private final Patient patient;
    private final List<Effect> effects;

    public PatientHandler(final Patient patient, final List<Effect> effects) {
        this.patient = patient;
        this.effects = effects;
    }

    public void giveDrugs() {
        final Iterator<Effect> iterator = effects.iterator();
        while (iterator.hasNext() && patient.checkPulse()) {
            final Effect effect = iterator.next();
            final Optional<StatusEnum> newStatus = effect.newStatus(patient);
            patient.updateStatus(newStatus.orElse(patient.getStatus()));
        }
        if (!patient.checkPulse()) {
            final Optional<StatusEnum> newStatus = FlyeingFlyingSpagethiMonters.instance().newStatus(patient);
            patient.updateStatus(newStatus.orElse(patient.getStatus()));
        }
    }
}

