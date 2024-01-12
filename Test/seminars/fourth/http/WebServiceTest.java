package seminars.fourth.http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WebServiceTest {
    private static WebService webService;
    private static HttpClient httpClient;

    @BeforeAll
    public static void init(){
        httpClient = mock(HttpClient.class);
        webService = new WebService(httpClient);
    }

    @Test
    void makeRequest() {
        String request = "https://vk.com";
        String answer = "page";
        when(httpClient.get(request)).thenReturn(answer);

        assertEquals(answer, webService.makeRequest(request));
    }
}