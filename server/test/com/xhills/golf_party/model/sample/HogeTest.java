package com.xhills.golf_party.model.sample;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class HogeTest extends AppEngineTestCase {

    private Hoge model = new Hoge();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
