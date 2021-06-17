package user.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.dto.UserRequest;
import user.dto.UserResponse;
import user.service.UserService;

import java.net.URI;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity create(@RequestBody UserRequest request) {
        UserResponse user = userService.create(request);
        return ResponseEntity.created(URI.create("/members/" + user.getId())).build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> find(@PathVariable String id) {
        UserResponse user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable String id, @RequestBody UserRequest request) {
        userService.update(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}