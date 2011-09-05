package com.xhills.golf_party.service.course;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CourseServiceTest extends AppEngineTestCase {

    private CourseService service = new CourseService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
