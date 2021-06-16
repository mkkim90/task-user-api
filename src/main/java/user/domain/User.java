package user.domain;

public class User {
    String id;
    String password;

    public User(String id, String password) {
        validRequiredId(id);
        validRequiredPassword(password);
        this.id = id;
        this.password = password;
    }

    private void validRequiredId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID는 필수 값입니다.");
        }
    }

    private void validRequiredPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("패스워드는 필수 값입니다.");
        }
    }
}
