package com.edgelab.behave.drug;

import com.edgelab.domain.DrugsEnum;
import com.edgelab.domain.Patient;
import com.edgelab.domain.StatusEnum;

import java.util.Optional;

public class Placebo implements Drug {


    private static final Placebo INSTANCE = new Placebo();

    private Placebo() {
    }

    public static Placebo getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<StatusEnum> newStatus(final Patient patient) {
        return Optional.empty();
    }

    @Override
    public DrugsEnum code() {
        return null;
    }
}
