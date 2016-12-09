package lab.aikibo.bookmarks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by tamami on 09/12/16.
 */
@SpringBootApplication
public class Application {

  public static void main(String args[]) {
    SpringApplication.run(Application.class, args);
  }

  // CORS
  @Bean
  FilterRegistrationBean corsFilter(
      @Value("${tagit.origin:http://localhost:9000}") String origin) {
    return new FilterRegistrationBean(new Filter() {
      public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
          throws IOException, ServletException {

      }
    });
  }

}
