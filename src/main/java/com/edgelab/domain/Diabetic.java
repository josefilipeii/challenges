package com.edgelab.domain;

public class Diabetic extends Patient {


    public Diabetic() {
        super(StatusEnum.D);
    }

    @Override
    public void updateStatus(final StatusEnum status) {
        if ((!checkPulse() && status == StatusEnum.H) || (checkPulse() && status == StatusEnum.X)) {
            super.updateStatus(status);
        }
    }
}
