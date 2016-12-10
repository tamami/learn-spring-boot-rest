package lab.aikibo.bookmarks;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by tamami on 10/12/16.
 */
public class BookmarkResource extends ResourceSupport {

  @Getter
  private final Bookmark bookmark;

  public BookmarkResource(Bookmark bookmark) {
    String username = bookmark.getAccount().getUsername();
    this.bookmark = bookmark;
    this.add(new Link(bookmark.uri, "bookmark-uri"));
    this.add(linkTo(BookmarkRestController.class, username).withRel("bookmarks"));
    this.add(linkTo(methodOn(BookmarkRestController.class, username).readBookmark(null, bookmark.getId())).withSelfRel());
  }

}
