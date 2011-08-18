package com.xhills.golf_party.model.sample;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class FooTest extends AppEngineTestCase {

    private Foo model = new Foo();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
