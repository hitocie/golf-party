package com.xhills.golf_party.service.course;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.xhills.golf_party.common.test.TestUtil;
import com.xhills.golf_party.model.course.Course;
import com.xhills.golf_party.model.course.Half;
import com.xhills.golf_party.model.course.Hole;

public class CourseServiceTest extends AppEngineTestCase {

    private CourseService service = new CourseService();

    @Test
    public void test() throws Exception {
        
        List<Course> courseList = service.getAll();
        assertNotNull(courseList);
        assertTrue(courseList.isEmpty());
        
        // creation
        TestUtil.createCourseData(service, "オレンジカントリークラブ", "東京都港区六本木");
        TestUtil.createCourseData(service, "イエローカントリークラブ", "愛知県名古屋市");
        TestUtil.createCourseData(service, "ブルーカントリークラブ", "宮崎県宮崎市");
        TestUtil.createCourseData(service, "レッドカントリークラブ", "千葉県千葉市");
        TestUtil.createCourseData(service, "ゴールドカントリークラブ", "埼玉県ダサい玉");
        
        for (Course c : service.getAll()) {
            System.out.println("course=" + c.getName());
            for (Half half : c.getHalfRef().getModelList()) {
                System.out.println(" half=" + half.getName());
                for (Hole hole : half.getHoleRef().getModelList()) {
                    System.out.print(" no:" + hole.getNo() + "=" + hole.getPar() + " ");
                }
                System.out.println("");
            }
        }
    }
}
