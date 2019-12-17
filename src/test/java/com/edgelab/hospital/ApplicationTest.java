package com.edgelab.hospital;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ApplicationTest {

    private final String status;
    private final String drugs;
    private final String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"F", "P", "F:0,H:1,D:0,T:0,X:0"}
                , {"D,D", "", "F:0,H:0,D:0,T:0,X:2"}
                , {"D,F,F,F,F", "I", "F:4,H:0,D:1,T:0,X:0"}
                , {"T,F", "As,An", "F:0,H:2,D:0,T:0,X:0"}
                , {"T,F,F,D,D,D", "As,P", "F:0,H:0,D:0,T:0,X:6"}
                , {"F,F,F,F,F,D", "P", "F:0,H:5,D:0,T:0,X:1"}
                , {"F,F,F,F,F,D", "I", "F:5,H:0,D:1,T:0,X:0"}
                , {"H,F,F,F,F,D", "I,An", "F:5,H:0,D:1,T:0,X:0"}
                , {"H,F,F,F,F,D", "As", "F:0,H:5,D:0,T:0,X:1"}
                , {"", "As", "F:0,H:0,D:0,T:0,X:0"}
                , {"", "", "F:0,H:0,D:0,T:0,X:0"}
                , {"H,H", "", "F:0,H:2,D:0,T:0,X:0"}

        });
    }

    public ApplicationTest(final String status, final String drugs, final String expected) {
        this.status = status;
        this.drugs = drugs;
        this.expected = expected;
    }

    @Test
    public void executeSimulation() {
        final String report = Application.executeSimulation(status, drugs);
        Assert.assertEquals(expected, report);
    }
}