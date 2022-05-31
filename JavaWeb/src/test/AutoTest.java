package test;

import dao.TestDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoTest {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext  appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestDao tt = (TestDao) appCon.getBean("test");
        tt.run();
    }
}
