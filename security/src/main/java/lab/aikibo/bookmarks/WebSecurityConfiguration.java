package lab.aikibo.bookmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by tamami on 10/12/16.
 */
@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

  @Autowired
  AccountRepository accountRepository;

  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailService());
  }

  @Bean
  UserDetailsService userDetailService() {
    return (username) -> accountRepository
        .findByUsername(username)
        .map(a -> new User(a.username, a.password, true, true, true, true, AuthorityUtils.createAuthorityList("USER", "write")))
        .orElseThrow( () -> new UsernameNotFoundException("could not find the user '" + username + "'"));
  }

}
