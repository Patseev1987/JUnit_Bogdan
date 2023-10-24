package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DataProcessorTest {
    @Test
    void checkDatabase(){
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);
        when(database.query(anyString())).thenReturn(List.of("1","2","3"));
        List<String> myData = database.query(anyString());
        verify(database,times(1)).query(anyString());
        assertThat(myData).isNotEmpty().hasSize(3).isEqualTo(List.of("1","2","3"));
    }

}