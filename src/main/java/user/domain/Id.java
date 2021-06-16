package user.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Id implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id1 = (Id) o;
        return Objects.equals(id, id1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
