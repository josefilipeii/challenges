package com.edgelab.hospital;

import com.edgelab.behave.PatientFactory;
import com.edgelab.behave.PatientHandler;
import com.edgelab.behave.drug.Drug;
import com.edgelab.behave.drug.DrugsDealer;
import com.edgelab.behave.sideeffect.SideEffectBinder;
import com.edgelab.domain.DrugsEnum;
import com.edgelab.domain.Effect;
import com.edgelab.domain.Patient;
import com.edgelab.domain.StatusEnum;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class Application {

    public static void main(final String[] args) {

        final String report = executeSimulation(args);

        System.out.println(report);
    }

    protected static String executeSimulation(final String... args) {
        final List<Patient> patients = createPatientsList(args[0]);

        final List<Drug> drugs = createDrugsList(args[1]);


        patients.stream().map(p -> {
            final List<Effect> effects = SideEffectBinder.instance().checkSideEffects(p, drugs);
            effects.addAll(drugs);
            return new PatientHandler(p, effects);
        }).forEach(PatientHandler::giveDrugs);

        final Map<StatusEnum, Long> patientsCount = patients.stream().map(Patient::getStatus).collect(Collectors.groupingBy(Function.identity(), counting()));

        final Map<StatusEnum, Long> counter = EnumSet.allOf(StatusEnum.class).stream().collect(Collectors.toMap(statusEnum -> statusEnum, statusEnum -> 0L));

        counter.putAll(patientsCount);

        return counter.entrySet().stream()
                .sorted(Comparator.comparingInt(o -> o.getKey().getOrder()))
                .map(e -> String.format("%s:%s", e.getKey(), e.getValue()))
                .collect(Collectors.joining(","));
    }

    private static List<Drug> createDrugsList(final String list) {
        if (list != null && list.length() > 0) {
            final String[] split = list.split(",");
            return Arrays.stream(split).map(s ->
                    DrugsDealer.instance().createDrug(DrugsEnum.valueOf(s))
            ).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private static List<Patient> createPatientsList(final String list) {
        if (list != null && list.length() > 0) {
            final String[] split = list.split(",");
            return Arrays.stream(split).map(s -> {
                return PatientFactory.instance().sortPatient(StatusEnum.valueOf(s));
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
