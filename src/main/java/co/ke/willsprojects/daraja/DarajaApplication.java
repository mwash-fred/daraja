package co.ke.willsprojects.daraja;

import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class DarajaApplication {

    @Bean
    public OkHttpClient getHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(DarajaApplication.class, args);
    }

}
