package user.domain;

public class Password {
    private String password;

    private Password(String password) {
        validRequired(password);
        this.password = password;
    }

    private void validRequired(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("패스워드는 필수 값입니다.");
        }
    }

    public static Password of(String password) {
        return new Password(password);
    }
}
