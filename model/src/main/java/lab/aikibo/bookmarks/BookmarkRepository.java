package lab.aikibo.bookmarks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by tamami on 08/12/16.
 */
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    Collection<Bookmark> findByAccountUsername(String username);

}
