package user.domain;


public class User {
    private Id id;
    private Password password;

    public User(String id, String password) {
        this.id = Id.of(id);
        this.password = Password.of(password);
    }

    public void chagePassword(String password) {
        this.password.changePassword(password);
    }
}
