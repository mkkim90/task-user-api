package user.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {
    private final String testId = "test1";
    private final String testPassword = "test0156!";

    @Test
    void create() {
        User user = new User(testId, testPassword);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validRequiredPasswordException(String password) {
        Assertions.assertThatThrownBy(() -> {
            new User(testId, password);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validRequiredIdException(String id) {
        Assertions.assertThatThrownBy(() -> {
            new User(id, testPassword);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void currentPassword() {
       Password.of(testPassword);
    }

    @ParameterizedTest
    @ValueSource(strings = {"mk12", "mkkim0424", "mkkim!", "!@#$)(*&^%$##", "mkkimtestpassword"})
    void validPasswordPolicyException(String password) {
        Assertions.assertThatThrownBy(() -> {
            Password.of(password);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"mk12!", "mkkim0424137289789", "test" ,"!@#$)(*&^%$##", "1234"})
    void validIdPolicyException(String id) {
        Assertions.assertThatThrownBy(() -> {
            Id.of(id);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("비밀번호 변경 시, 이전 비밀번호와 동일한 경우 - 예외 발생")
    @Test
    void validChangePassword() {
        User user = new User(testId, testPassword);
        Assertions.assertThatThrownBy(() -> {
            user.chagePassword(testPassword);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
