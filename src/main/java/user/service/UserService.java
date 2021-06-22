package user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.domain.Id;
import user.domain.User;
import user.dto.UserRequest;
import user.dto.UserResponse;
import user.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<UserResponse> list() {
        List<User> list = userRepository.findAll();
        return list.stream()
                .map(UserResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserResponse findById(String id) {
        User user = findUserById(id);
        return UserResponse.of(user);
    }

    public UserResponse create(UserRequest request) {
        validateExistId(request);
        User user = userRepository.save(request.toUser());
        return UserResponse.of(user);
    }

    private void validateExistId(UserRequest request) {
        if (isExistsById(request.getId())) {
            throw new IllegalArgumentException("이미 존재하는 ID 입니다.");
        }
    }

    private boolean isExistsById(String id) {
        return userRepository.existsById(Id.of(id));
    }

    public void update(String id, UserRequest userRequest) {
        User user = findUserById(id);
        user.chagePassword(userRequest.getPassword());
    }

    public User findUserById(String id) {
        return userRepository.findById(Id.of(id))
                .orElseThrow(EntityNotFoundException::new);
    }

    public void deleteUser(String id) {
        validateExistDeleteUser(id);
        userRepository.deleteById(Id.of(id));
    }

    private void validateExistDeleteUser(String id) {
        if (isExistsById(id)) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
    }
}
