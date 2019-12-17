package com.edgelab.domain;

public class Patient implements Alive {

    private StatusEnum status;

    public Patient(final StatusEnum status) {
        this.status = status;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void updateStatus(final StatusEnum status) {
        this.status = status;
    }


    @Override
    public boolean checkPulse() {
        return StatusEnum.X != status;
    }
}
