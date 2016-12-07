package lab.aikibo.bookmarks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by tamami on 20/11/16.
 */
@Entity
@Data
public class Bookmark {

  @JsonIgnore
  @ManyToOne
  private Account account;

  @Id
  @GeneratedValue
  private Long id;

  public String uri;
  public String description;

  public Bookmark(Account account, String uri, String description) {
    this.account = account;
    this.uri = uri;
    this.description = description;
  }

  Bookmark() {}

}
