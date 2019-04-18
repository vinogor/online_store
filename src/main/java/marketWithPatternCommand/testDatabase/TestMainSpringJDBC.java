package marketWithPatternCommand.testDatabase;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TestMainSpringJDBC {

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");

        WorkWithDB workWithDB = (WorkWithDB) appContext.getBean("workWithDB");
        workWithDB.getItems();

//        SomeClass someClass = new SomeClass();
//        someClass.start();

        appContext.close();
    }
}