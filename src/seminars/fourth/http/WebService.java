package seminars.fourth.http;

public class WebService {
    HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getData (){
       return   httpClient.get("123");
    }
}
