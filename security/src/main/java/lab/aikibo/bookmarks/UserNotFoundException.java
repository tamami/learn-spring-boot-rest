package lab.aikibo.bookmarks;

/**
 * Created by tamami on 10/12/16.
 */
@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(String userId) {
    super("Could not find user '" + userId + "'.");
  }

}
