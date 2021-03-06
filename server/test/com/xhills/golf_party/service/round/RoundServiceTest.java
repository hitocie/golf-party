package com.xhills.golf_party.service.round;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.xhills.golf_party.model.round.Round;

public class RoundServiceTest extends AppEngineTestCase {

    private RoundService service = new RoundService();

    @Test
    public void test() throws Exception {
        List<Round> roundList = service.getAllRounds();
        assertNotNull(roundList);
        assertTrue(roundList.isEmpty());
        
        // creation
//        TestUtil.createUserData(new UserService());
//        TestUtil.createCourseData(new CourseService(), "テストコース", "東京");
//        TestUtil.createRoundData(service);
        
        for (Round round : service.getAllRounds()) {
            System.out.println(round.getWeather() + " " + round.getCourseRef().getModel().getName());
        }
            
    }
}
