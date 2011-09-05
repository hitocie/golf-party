package com.xhills.golf_party.model.course;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class HalfTest extends AppEngineTestCase {

    private Half model = new Half();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
