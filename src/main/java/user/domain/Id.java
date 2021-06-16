package user.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Id {
    private String id;

    private Id(String id) {
        validRequired(id);
        validIdPolicy(id);
        this.id = id;
    }

    private void validRequired(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID는 필수 값입니다.");
        }
    }

    private void validIdPolicy(String id) {
        final String idPolicyRegularExpession = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
        Pattern pattern = Pattern.compile(idPolicyRegularExpession);
        Matcher matcher = pattern.matcher(id);
        if(!matcher.matches()) {
            throw new IllegalArgumentException("아이디는 영문 숫자 조합 5~12 이하만 가능합니다.");
        }
    }

    public static Id of(String id) {
        return new Id(id);
    }
}
