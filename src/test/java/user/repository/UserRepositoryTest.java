package user.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import user.domain.Id;
import user.domain.Password;
import user.domain.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        final User expected = new User("test1", "test0616!");
        final User actual = userRepository.save(expected);
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    void update() {
        // given
        User user = userRepository.save(new User("test1", "test0616!"));

        // when
        String expectedPassword = "test0617!";
        user.chagePassword(expectedPassword);
        userRepository.flush();

        assertThat(userRepository.findByPassword(Password.of(expectedPassword)).get()).isEqualTo(user);
    }

    @Test
    void delete() {
        // given
        User user = userRepository.save(new User("test1", "test0616!"));

        // when
        userRepository.delete(user);

        // then
        assertThat(userRepository.findById(Id.of("test1")).isPresent()).isFalse();
    }

}
