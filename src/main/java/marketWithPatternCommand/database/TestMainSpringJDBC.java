package marketWithPatternCommand.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TestMainSpringJDBC {

    @Autowired
    private static SpringJdbcAndH2db db;

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");

//        SpringJdbcAndH2db springJdbcAndH2db = (SpringJdbcAndH2db) appContext.getBean("springJdbcAndH2db");
//        springJdbcAndH2db.getItems();

        System.out.println(db);
        db.getItems();

        appContext.close();
    }
}