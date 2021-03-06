package user.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@EqualsAndHashCode
@Embeddable
public class Id implements Serializable {

    private String id;

    protected  Id() {
    }

    private Id(String id) {
        checkNotNull(id);
        validIdPolicy(id);
        this.id = id;
    }

    private void checkNotNull(String id) {
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
