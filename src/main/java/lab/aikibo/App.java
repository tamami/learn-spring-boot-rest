package lab.aikibo;

import lab.aikibo.bookmarks.Account;
import lab.aikibo.bookmarks.AccountRepository;
import lab.aikibo.bookmarks.Bookmark;
import lab.aikibo.bookmarks.BookmarkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner init(final AccountRepository accountRepository, final BookmarkRepository bookmarkRepository) {
        return (evt) -> Arrays.asList(
            "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
            .forEach(
                a -> {
                    Account account = accountRepository.save(new Account(a, "password"));
                    bookmarkRepository.save(new Bookmark(account,
                        "http://bookmark.com/1/" + a, "A description"));
                    bookmarkRepository.save(new Bookmark(account,
                        "http://bookmark.com/2/" + a, "A description"));
                }
            );
        );
    }
}
