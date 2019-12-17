package com.edgelab.behave.drug;

import com.edgelab.domain.DrugsEnum;

public final class DrugsDealer {

    private static final DrugsDealer INSTANCE = new DrugsDealer();

    private DrugsDealer() {
    }

    public static DrugsDealer instance() {
        return INSTANCE;
    }

    public Drug createDrug(final DrugsEnum drug) {
        switch (drug) {
            case An:
                return Antibiotic.getInstance();
            case As:
                return Aspirin.getInstance();
            case I:
                return Insulin.getInstance();
            case P:
                return Paracetamol.getInstance();
            default:
                return Placebo.getInstance();
        }
    }
}
