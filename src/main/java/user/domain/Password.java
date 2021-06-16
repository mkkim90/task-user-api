package user.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String password;

    private Password(String password) {
        validRequired(password);
        validPasswordPolicy(password);
        this.password = password;
    }

    private void validRequired(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("패스워드는 필수 값입니다.");
        }
    }

    private void validPasswordPolicy(String password) {
        final String passwordPolicyRegularExpession = "((?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9가-힣]).{8,})";
        Pattern pattern = Pattern.compile(passwordPolicyRegularExpession);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.matches()) {
            throw new IllegalArgumentException("8자리 이상 특수문자, 숫자, 영어 소문자 중 3가지 이상을 조합해서 작성하세요.");
        }
    }

    public static Password of(String password) {
        return new Password(password);
    }
}
