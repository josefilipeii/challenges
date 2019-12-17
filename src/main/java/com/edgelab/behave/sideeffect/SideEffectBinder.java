package com.edgelab.behave.sideeffect;

import com.edgelab.behave.drug.Drug;
import com.edgelab.domain.DrugsEnum;
import com.edgelab.domain.Effect;
import com.edgelab.domain.Patient;
import com.edgelab.domain.StatusEnum;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class SideEffectBinder {

    private static final SideEffectBinder INSTANCE = new SideEffectBinder();

    private SideEffectBinder() {
    }

    public static SideEffectBinder instance() {
        return INSTANCE;
    }


    public List<Effect> checkSideEffects(final Patient patient, final List<Drug> drugs) {
        final List<Effect> result = new ArrayList<>();
        final Set<DrugsEnum> drugCodes = drugs.stream().map(Drug::code).collect(Collectors.toSet());


        final boolean aspirineAndParacetamol = drugCodes.containsAll(EnumSet.of(DrugsEnum.As, DrugsEnum.P));
        final boolean diabeticWithNoInsuline = patient.getStatus() == StatusEnum.D && !drugCodes.contains(DrugsEnum.I);
        if (aspirineAndParacetamol || diabeticWithNoInsuline) {
            result.add(DeathSideEffect.getInstance());
        } else if (patient.getStatus() == StatusEnum.H && drugCodes.containsAll(EnumSet.of(DrugsEnum.I, DrugsEnum.An))) {
            result.add(FeverSideEffect.getInstance());
        }


        return result;
    }

}
