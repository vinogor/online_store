package marketWithPatternCommand.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");

        JdbcRepo jdbcRepo = (JdbcRepo) appContext.getBean("jdbcRepo");
        jdbcRepo.getTableStore();
//        JdbcRepo jdbcRepo = new JdbcRepo();
//        jdbcRepo.getTableStore();
    }
}


