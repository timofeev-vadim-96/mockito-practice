package seminars.fourth.database;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DataProcessorTest {
    private static Database database;
    private static DataProcessor dataProcessor;

    @BeforeAll
    public static void init(){
        database = mock(Database.class);
        dataProcessor = new DataProcessor(database);

        when(database.query("SELECT * FROM table")).thenReturn(List.of("data1", "data2"));
    }

    @Test
    public void pricesDataTest(){
        List<String> list = List.of("data1", "data2");
        assertEquals(list, dataProcessor.processData("SELECT * FROM table"));
    }

}