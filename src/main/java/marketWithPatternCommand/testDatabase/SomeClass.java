package marketWithPatternCommand.testDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeClass {

    @Autowired
    WorkWithDB workWithDB;

    public void start() {

        System.out.println("workWithDB = " + workWithDB);
        workWithDB.getItems();
    }
}
