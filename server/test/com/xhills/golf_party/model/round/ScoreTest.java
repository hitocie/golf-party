package com.xhills.golf_party.model.round;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ScoreTest extends AppEngineTestCase {

    private Score model = new Score();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
