package lab.aikibo.bookmarks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;

/**
 * Created by tamami on 18/11/16.
 */
<<<<<<< HEAD
=======
@Entity
@Data
>>>>>>> eff4b2caf29faa47112475066afcc53e977d8cc6
public class Account {

  @OneToMany(mappedBy = "account")
  private Set<Bookmark> bookmarks = new HashSet<>();

  @Id
  @GeneratedValue
  private Long id;

  @JsonIgnore
  public String password;
  public String username;

  public Account(String name, String password) {
    this.username = name;
    this.password = password;
  }

  Account() {}

}
