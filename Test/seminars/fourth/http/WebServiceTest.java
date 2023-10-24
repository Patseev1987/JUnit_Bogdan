package seminars.fourth.http;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class WebServiceTest {
    @Test
    void checkWebService (){
        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.get(anyString())).thenReturn("my test data");
        String request = webService.getData();
        verify(httpClient,times(1)).get(anyString());
        assertThat(request).isNotEmpty().isEqualTo("my test data");
    }
}
