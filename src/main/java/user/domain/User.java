package user.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class User extends BaseTimeEntity{

    @EmbeddedId
    private Id id;

    @Embedded
    private Password password;

    public User(String id, String password) {
        this.id = Id.of(id);
        this.password = Password.of(password);
    }

    public void chagePassword(String password) {
        this.password.changePassword(password);
    }
}
