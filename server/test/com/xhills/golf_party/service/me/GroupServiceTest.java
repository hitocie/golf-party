package com.xhills.golf_party.service.me;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GroupServiceTest extends AppEngineTestCase {

    private GroupService service = new GroupService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
