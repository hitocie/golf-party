package com.xhills.golf_party.model.course;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class HoleTest extends AppEngineTestCase {

    private Hole model = new Hole();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
