package marketWithPatternCommand.database;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMainSpringJDBC {

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");

        SpringJdbcAndH2db springJdbcAndH2db = (SpringJdbcAndH2db) appContext.getBean("springJdbcAndH2db");
        springJdbcAndH2db.getItems();

        appContext.close();
    }
}