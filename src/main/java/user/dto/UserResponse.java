package user.dto;

import lombok.Data;
import user.domain.User;

@Data
public class UserResponse {
    private String id;
    private String password;

    public UserResponse(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public static UserResponse of(User user) {
        return new UserResponse(user.getIdForUserResponse(), user.getPasswordForUserResponse());
    }

}
