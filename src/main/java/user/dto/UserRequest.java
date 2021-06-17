package user.dto;

import lombok.Data;
import user.domain.User;

@Data
public class UserRequest {
    private String id;
    private String password;

    public UserRequest(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public User toUser() {
        return new User(id, password);
    }
}
