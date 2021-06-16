package user.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class UserTest {

    @Test
    void create() {
        User user = new User("mkzzang0928","mkkim0424");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validRequiredPasswordException(String password) {
        Assertions.assertThatThrownBy(() -> {
            new User("mkzzang0928", password);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validRequiredIdException(String id) {
        Assertions.assertThatThrownBy(() -> {
            new User(id, "1234fvmnjknfjk");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
