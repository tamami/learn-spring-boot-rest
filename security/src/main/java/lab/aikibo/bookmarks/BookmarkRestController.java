package lab.aikibo.bookmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.stream.Collectors;

/**
 * Created by tamami on 10/12/16.
 */
@RestController
@RequestMapping("/bookmarks")
public class BookmarkRestController {

  private final BookmarkRepository bookmarkRepository;
  private final AccountRepository accountRepository;

  @Autowired
  BookmarkRestController(BookmarkRepository bookmarkRepository, AccountRepository accountRepository) {
    this.bookmarkRepository = bookmarkRepository;
    this.accountRepository = accountRepository;
  }

  @RequestMapping(method = RequestMethod.GET)
  Resources<BookmarkResource> readBookmarks(Principal principal) {
    this.validateUser(principal);

    List<BookmarkResource> bookmarkResourceList = bookmarkRepository
        .findByAccountUsername(principal.getName()).stream()
        .map(BookmarkResource::new)
        .collect(Collectors.toList());

    return new Resources<>(bookmarkResourceList);
  }

}
