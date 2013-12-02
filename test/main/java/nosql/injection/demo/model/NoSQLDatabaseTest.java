package main.java.nosql.injection.demo.model;

import nosql.injection.demo.model.InjectionResult;
import nosql.injection.demo.model.NoSQLDatabase;
import org.junit.Test;
import java.net.UnknownHostException;
import static org.junit.Assert.assertEquals;

public class NoSQLDatabaseTest {

    @Test
    public void insecureFindReturnsMultipleResults() throws UnknownHostException {
        InjectionResult result = NoSQLDatabase.getInstance().insecureFindByName("abd',name:{$ne:'Robb'},address:'Casterly Rock");
        assertEquals(4, result.getResult().count());
    }

    @Test
    public void secureFindReturnsNoResults() throws UnknownHostException {
        InjectionResult result = NoSQLDatabase.getInstance().secureFindByName("abd',name:{$ne:'Robb'},address:'Casterly Rock");
        assertEquals(0, result.getResult().count());
    }
}
