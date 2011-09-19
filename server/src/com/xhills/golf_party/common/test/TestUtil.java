package com.xhills.golf_party.common.test;

import com.xhills.golf_party.model.common.User;
import com.xhills.golf_party.service.common.UserService;

public class TestUtil {

    public static void createUserData(UserService service) throws Exception {
        User user1 = new User();
        user1.setId("10000");
        user1.setName("Hitoshi Okada");

        User user2 = new User();
        user2.setId("20000");
        user2.setName("Yuki Arai");

        User user3 = new User();
        user3.setId("30000");
        user3.setName("Nao Okamoto");

        User user4 = new User();
        user4.setId("40000");
        user4.setName("Akira Mori");
        
        service.createUser(user1);
        service.createUser(user2);
        service.createUser(user3);
        service.createUser(user4);
    }
    
//    public static void createCourseData(
//            CourseService service,
//            String courseName,
//            String courseAddress
//    ) throws Exception {
//        
//        Random r = new Random();
//        
//        // creation
//        Course course = new Course();
//        course.setName(courseName);
//        course.setAddress(courseAddress);
//        List<List<Hole>> halfHoles = new ArrayList<List<Hole>>();
//        for (int i = 0; i < 2; i++) {
//            List<Hole> holes = new ArrayList<Hole>();
//            for (int j = 0; j < 9; j++) {
//                Hole hole = new Hole();
//                hole.setNo(j + 1);
//                hole.setPar(r.nextInt(3) + 3);
//                hole.setRedYard(r.nextInt(100) + 150);
//                hole.setWhiteYard(r.nextInt(100) + 250);
//                hole.setBackYard(r.nextInt(100) + 350);
//                hole.setHandicap(j + 1);
//                holes.add(hole);
//            }
//            halfHoles.add(holes);
//        }
//        List<Half> halfs = new ArrayList<Half>();
//        halfs.add(new Half());
//        halfs.get(0).setName("OUT");
//        halfs.add(new Half());
//        halfs.get(1).setName("IN");
//        
//        //service.createCourse(course, halfs, halfHoles);
//    }
//    
//    
//    public static void createRoundData(RoundService service) throws Exception {
//        
//        // creation
//        Round round = new Round();
//        CourseService courseService = new CourseService();
//        round.getCourseRef().setModel(courseService.getAll().get(0));
//        round.setDate(new Date());
//        round.setWeather(Weather.fine);
//        round.setWind(Wind.strong);
//        
//        List<RoundGroup> roundGroups = new ArrayList<RoundGroup>();
//        List<List<RoundMember>> roundMembers = new ArrayList<List<RoundMember>>();
//        List<List<List<Score>>> scores = new ArrayList<List<List<Score>>>();
//        for (int i = 0; i < 2; i++) {
//            RoundGroup rg = new RoundGroup();
//            List<RoundMember> rms = new ArrayList<RoundMember>();
//            List<List<Score>> sss = new ArrayList<List<Score>>();
//            for (int j = 0; j < 4; j++) {
//                RoundMember rm = new RoundMember();
//                UserService userService = new UserService();
//                rm.getUserRef().setModel(userService.getAll().get(j));
//                List<Score> ss = new ArrayList<Score>();
//                for (int k = 0; k < 18; k++) {
//                    Score s = new Score();
//                    s.setScore(7);
//                    s.setPutter(2);
//                    ss.add(s);
//                }
//                rms.add(rm);
//                sss.add(ss);
//            }
//            roundGroups.add(rg);
//            roundMembers.add(rms);
//            scores.add(sss);
//        }
//        
//        service.insert(round, roundGroups, roundMembers, scores);
//    }
}
