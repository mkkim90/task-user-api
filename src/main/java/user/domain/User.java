package user.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Getter
@EqualsAndHashCode
@Entity
public class User extends BaseTimeEntity{

    @EmbeddedId
    private Id id;

    @Embedded
    private Password password;

    protected User() {
    }

    public User(String id, String password) {
        this.id = Id.of(id);
        this.password = Password.of(password);
    }

    public void chagePassword(String password) {
        this.password.changePassword(password);
    }

    public String getIdForUserResponse() {
        return this.id.getId();
    }

    public String getPasswordForUserResponse() {
        return this.password.getPassword();
    }


}
