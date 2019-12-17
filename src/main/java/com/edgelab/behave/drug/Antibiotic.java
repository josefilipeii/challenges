package com.edgelab.behave.drug;

import com.edgelab.domain.DrugsEnum;
import com.edgelab.domain.Patient;
import com.edgelab.domain.StatusEnum;

import java.util.Optional;

public class Antibiotic implements Drug {


    private static final Antibiotic INSTANCE = new Antibiotic();

    private Antibiotic() {
    }

    public static Antibiotic getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<StatusEnum> newStatus(final Patient patient) {
        if (patient.getStatus() == StatusEnum.T) {
            return Optional.of(StatusEnum.H);
        }
        return Optional.empty();
    }

    @Override
    public DrugsEnum code() {
        return DrugsEnum.An;
    }


}
