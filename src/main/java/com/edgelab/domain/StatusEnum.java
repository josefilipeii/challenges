package com.edgelab.domain;

public enum StatusEnum {
    F(1), H(2), D(3), T(4), X(5);

    private final int order;

    StatusEnum(final int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
