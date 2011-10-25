package com.xhills.golf_party.model.me;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GroupTest extends AppEngineTestCase {

    private Group model = new Group();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
