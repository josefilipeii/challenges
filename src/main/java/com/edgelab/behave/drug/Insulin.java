package com.edgelab.behave.drug;

import com.edgelab.domain.DrugsEnum;

public class Insulin implements Drug {


    private static final Insulin INSTANCE = new Insulin();

    private Insulin() {
    }

    public static Insulin getInstance() {
        return INSTANCE;
    }

    @Override
    public DrugsEnum code() {
        return DrugsEnum.I;
    }


}
