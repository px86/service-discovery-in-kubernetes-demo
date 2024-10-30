package io.github.px86.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/")
public class ServiceAApplication {

  @Value("${service-b.url}")
  private String serviceBUrl;

  @Autowired private RestClient restClient;

  public static void main(String[] args) {
    SpringApplication.run(ServiceAApplication.class, args);
  }

  @GetMapping("/")
  public String home() {
    String resposne =
        restClient.get().uri(serviceBUrl + "/api/v1/resource").retrieve().body(String.class);
    return "Response from Service-B: " + resposne;
  }
}
