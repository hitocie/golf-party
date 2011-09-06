package com.xhills.golf_party.model.round;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class RoundGroupTest extends AppEngineTestCase {

    private RoundGroup model = new RoundGroup();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
