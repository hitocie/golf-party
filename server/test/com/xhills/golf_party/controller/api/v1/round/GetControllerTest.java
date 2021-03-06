package com.xhills.golf_party.controller.api.v1.round;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GetControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/api/v1/round/get");
        GetController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
