package com.xhills.golf_party.service.sample;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.xhills.golf_party.model.sample.Foo;
import com.xhills.golf_party.model.sample.Hoge;

public class FirstServiceTest extends AppEngineTestCase {

    private FirstService service = new FirstService();

    @Test
    public void test() throws Exception {
        //assertThat(service, is(notNullValue()));
        List<Foo> fooList = service.getAll();
        assertNotNull(fooList);
        assertTrue(fooList.isEmpty());
        
        // creation
        Foo foo1= new Foo();
        foo1.setName("hokada");
        foo1.setAge(35);
        List<Hoge> hoges1 = new ArrayList<Hoge>();
        Hoge hoge11 = new Hoge();
        hoge11.setText("1-1");
        hoges1.add(hoge11);
        Hoge hoge12 = new Hoge();
        hoge12.setText("1-2");
        hoges1.add(hoge12);
        service.insert(foo1, hoges1);
        
        Foo foo2= new Foo();
        foo2.setName("doraemon");
        foo2.setAge(100);
        List<Hoge> hoges2 = new ArrayList<Hoge>();
        Hoge hoge21 = new Hoge();
        hoge21.setText("2-1");
        hoges2.add(hoge21);
        Hoge hoge22 = new Hoge();
        hoge22.setText("2-2");
        hoges2.add(hoge22);
        service.insert(foo2, hoges2);
        
        for (Foo f : service.getAll()) {
            System.out.println("foo=" + f.getName());
            for (Hoge h : f.getHogeRef().getModelList())
                System.out.println("  hoge=" + h.getText());
        }
    }
}
