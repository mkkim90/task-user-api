package user.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password);
    }

    public Id getId() {
        return this.id;
    }

    public String getIdForUserResponse() {
        return this.id.getId();
    }

    public Password getPassword() {
        return this.password;
    }

    public String getPasswordForUserResponse() {
        return this.password.getPassword();
    }


}
