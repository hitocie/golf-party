package com.xhills.golf_party.model.round;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class RoundTest extends AppEngineTestCase {

    private Round model = new Round();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
