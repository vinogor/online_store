package marketWithPatternCommand.database;

import org.springframework.beans.factory.annotation.Autowired;

public class SomeClass {

    @Autowired
    SpringJdbcAndH2db db;

    public void start() {

        System.out.println(db);
        db.getItems();
    }
}
