package com.edgelab.behave;

import com.edgelab.domain.Diabetic;
import com.edgelab.domain.Patient;
import com.edgelab.domain.StatusEnum;

public final class PatientFactory {

    private static final PatientFactory INSTANCE = new PatientFactory();

    private PatientFactory() {
    }

    public static PatientFactory instance() {
        return INSTANCE;
    }

    public Patient sortPatient(final StatusEnum status) {
        if (status == StatusEnum.D) {
            return new Diabetic();
        }
        return new Patient(status);
    }
}
